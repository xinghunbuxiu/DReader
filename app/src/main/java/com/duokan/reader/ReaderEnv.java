package com.duokan.reader;

import android.app.Application;
import android.app.DownloadManager;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.KeyCharacterMap;

import com.duokan.core.a.a;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.core.app.IActivityRunStatusChanged;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.af;
import com.duokan.core.sys.ah;
import com.duokan.core.sys.i;
import com.duokan.kernel.DkUtils;
import com.duokan.lib.archive.DkarchLib;

import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import miuipub.os.SystemProperties;

public class ReaderEnv implements IActivityRunStatusChanged {
    protected static ReaderEnv a = null;
    static final /* synthetic */ boolean c;
    private static final String d = (File.separator + "lib");
    private static final String e = (File.separator + "www");
    private static final String f = ("DkKernel" + File.separator + "Resource" + File.separator + "WordSeg");
    private static final String g = ("DkKernel" + File.separator + "Resource" + File.separator + "Font");
    private static final String h = (File.separator + "Cache");
    private static final String i = (h + File.separator + "temp");
    private static final String j = (File.separator + "Downloads");
    private static final String k = (j + File.separator + "Cloud");
    private static final String l = (j + File.separator + "Local");
    private static final String m = (j + File.separator + "WiFi");
    private static final String n = (j + File.separator + "Covers");
    private static final String o = (j + File.separator + "CloudPrivateBooks");
    private static final String p = (j + File.separator + "MiCloudBooks");
    private static final String q = (File.separator + "Resource" + File.separator + "Font");
    private static final String r = (File.separator + "Plugins");
    private static final String s = (r + File.separator + "Dict");
    private File A = null;
    private File B = null;
    private File C = null;
    private Editor D = null;
    private final a E;
    private final HashMap F = new HashMap();
    private final i G = new i();
    private final i H = new i();
    private final i I = new i();
    private final ConcurrentHashMap J = new ConcurrentHashMap();
    private final CopyOnWriteArrayList K = new CopyOnWriteArrayList();
    private OnBookshelfItemStyleChangedListener L = null;
    protected final DkApp b;
    private final String t;
    private final SharedPreferences u;
    private final af v = new af();
    private final File w;
    private final File x;
    private final File y;
    private File z = null;

    public enum BookShelfType {
        Simple,
        Tradition
    }

    public enum BookshelfItemStyle {
        SIMPLE,
        TRADITIONAL
    }

    class GlobalPrefKeys {
        private GlobalPrefKeys() {
        }
    }

    public interface OnBookShelfTypeChangedListener {
        void onBookShelfTypeChanged(BookShelfType bookShelfType);
    }

    public interface OnBookshelfItemStyleChangedListener {
        void onBookshelfItemStyleChanged(BookshelfItemStyle bookshelfItemStyle);
    }

    public interface OnReaderPrefChangedListener {
        void onReaderPrefChanged(PrivatePref privatePref, String str);
    }

    public enum PrivatePref {
        GLOBAL,
        READING,
        BOOKSHELF,
        PERSONAL,
        STORE,
        USER_GUIDE,
        WELCOME
    }

    static {
        boolean z;
        if (ReaderEnv.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        c = z;
    }

    public ReaderEnv(DkApp dkApp) {
        configHttps();
        this.b = dkApp;
        this.t = this.b.getAppName();
        this.u = dkApp.getSharedPreferences("env", 0);
        this.u.registerOnSharedPreferenceChangeListener(new OnSharedPreferenceChangeListener(this) {
            final /* synthetic */ ReaderEnv a;

            {
                this.a = r1;
            }

            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                try {
                    String[] split = str.split("__");
                    PrivatePref valueOf = PrivatePref.valueOf(split[0].toUpperCase(Locale.US));
                    String str2 = split[1];
                    CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.a.J.get(valueOf);
                    if (copyOnWriteArrayList != null) {
                        Iterator it = copyOnWriteArrayList.iterator();
                        while (it.hasNext()) {
                            ((OnReaderPrefChangedListener) it.next()).onReaderPrefChanged(valueOf, str2);
                        }
                    }
                } catch (Throwable th) {
                }
            }
        });
        this.w = this.b.getFilesDir();
        this.x = new File(Environment.getExternalStorageDirectory(), this.t);
        this.y = new File(this.w, "res.v17");
        this.z = secondaryFilesDir(this.x);
        int i = this.u.getInt("global__version_code", 0);
        if (this.u.contains("global__app_activated")) {
            getPrefsEditor().putBoolean("global__fresh_install", false);
        } else {
            boolean z;
            if (!this.u.contains("global__first_version_code")) {
                getPrefsEditor().putInt("global__first_version_code", i == 0 ? getVersionCode() : i);
            }
            Editor prefsEditor = getPrefsEditor();
            String str = "global__fresh_install";
            if (new File(this.x, j).exists()) {
                z = false;
            } else {
                z = true;
            }
            prefsEditor.putBoolean(str, z);
        }
        if (i != getVersionCode()) {
            getPrefsEditor().putInt("global__last_version_code", i);
            getPrefsEditor().putInt("global__version_code", getVersionCode());
            if ((getVersionCode() / 10000000) - (i / 10000000) > 0) {
                getPrefsEditor().putBoolean("global__app_store_guide", true);
                getPrefsEditor().putInt("global__use_days", 0);
                getPrefsEditor().putLong("global__advanced_action_time", 0);
            }
            if (getUpdateDownloadTaskId() != -1) {
                try {
                    ((DownloadManager) this.b.getSystemService("download")).remove(new long[]{getUpdateDownloadTaskId()});
                } catch (Exception e) {
                }
                setUpdateDownloadTaskId(-1);
            }
        }
        if (!TextUtils.isEmpty(DkPublic.getDkDistChannel(this.b)) && TextUtils.isEmpty(this.u.getString("global__dist_channel", ""))) {
            getPrefsEditor().putString("global__dist_channel", DkPublic.getDkDistChannel(this.b));
        }
        ensureDirectoryExists(this.w);
        ensureDirectoryExists(this.x);
        ensureDirectoryExists(this.z);
        this.E = new a(Uri.fromFile(new File(getDatabaseDirectory(), "reader.db")).toString());
        if (i < 413000000 && this.z.compareTo(this.x) != 0) {
            File[] fileArr = (File[]) com.duokan.core.io.a.b(this.b).toArray(new File[0]);
            File file = fileArr[fileArr.length - 1];
            setPrefString(PrivatePref.PERSONAL, "storage", file.getAbsolutePath());
            this.z = new File(file, this.t);
            ensureDirectoryExists(this.z);
        }
        ah.a(new Runnable(this) {
            final /* synthetic */ ReaderEnv a;

            {
                this.a = r1;
            }

            public void run() {
                File access$100 = this.a.sysFontFileZh();
                File access$200 = this.a.sysFontFileEn();
                this.a.G.a(access$100);
                this.a.H.a(access$200);
                this.a.I.a(this.a.b.getResources().getDrawable(e.reading__reading_themes_vine_yellow_shadow));
                this.a.prepareInternalFiles();
                if (!this.a.z.equals(this.a.x)) {
                    Object obj;
                    for (File access$1002 : com.duokan.core.io.a.b(this.a.b)) {
                        if (this.a.z.getParentFile().equals(access$1002)) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        this.a.setSecondaryStorageDirectory(this.a.x.getParentFile());
                    }
                }
            }
        });
        commitPrefs();
        this.b.runPreReady(new Runnable(this) {
            final /* synthetic */ ReaderEnv a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.b.addOnRunningStateChangedListener(this.a);
            }
        });
    }

    public Application getApplication() {
        return this.b;
    }

    public Resources getResources() {
        return this.b.getApplicationContext().getResources();
    }

    public boolean isWebAccessEnabled() {
        return this.b.isWebAccessEnabled();
    }

    public File getWwwDirectory() {
        return new File(this.y, e);
    }

    public File getDatabaseDirectory() {
        File parentFile = this.b.getDatabasePath("name").getParentFile();
        ensureDirectoryExists(parentFile);
        return parentFile;
    }

    public File getKernelDirectory() {
        return new File(this.y, "DkKernel");
    }

    public File getKernelFontDirectory() {
        return new File(this.y, g);
    }

    public File getCacheDirectory() {
        File file = new File(this.x, h);
        ensureDirectoryExists(file);
        return file;
    }

    public File getReadingCacheDirectory() {
        File file = new File(getPrivateCacheDirectory(), "reading");
        ensureDirectoryExists(file);
        return file;
    }

    public File getStoreCacheDirectory() {
        File file = new File(getPrivateCacheDirectory(), "store");
        ensureDirectoryExists(file);
        return file;
    }

    public File getPrivateCacheDirectory() {
        File cacheDir = this.b.getCacheDir();
        ensureDirectoryExists(cacheDir);
        return cacheDir;
    }

    public File getTempDirectory() {
        File file = new File(this.x, i);
        ensureDirectoryExists(file);
        return file;
    }

    public File getLocalBookDirectory() {
        File file = new File(this.x, l);
        ensureDirectoryExists(file);
        return file;
    }

    public File getWiFiDirectory() {
        File file = new File(this.z, m);
        ensureDirectoryExists(file);
        return file;
    }

    public File[] getWiFiDirectories() {
        File[] externalFilesDirectories = getExternalFilesDirectories();
        File[] fileArr = new File[externalFilesDirectories.length];
        for (int i = 0; i < externalFilesDirectories.length; i++) {
            fileArr[i] = new File(externalFilesDirectories[i], m);
            ensureDirectoryExists(fileArr[i]);
        }
        return fileArr;
    }

    public File getCloudBookDirectory() {
        File file = this.A;
        if (file != null) {
            return file;
        }
        file = new File(this.z, k);
        ensureDirectoryExists(file);
        this.A = file;
        return file;
    }

    public File getMiCloudBookDirectory() {
        File file = this.B;
        if (file != null) {
            return file;
        }
        file = new File(this.z, p);
        ensureDirectoryExists(file);
        this.B = file;
        return file;
    }

    public File getDownloadedCoverDirectory() {
        File file = this.C;
        if (file != null) {
            return file;
        }
        file = new File(this.z, n);
        ensureDirectoryExists(file);
        this.C = file;
        return file;
    }

    public boolean isMiCloudBookPath(String str) {
        return str.contains(new StringBuilder().append(File.separator).append(this.t).append(p).toString()) || str.contains(File.separator + this.t + o);
    }

    public File getPluginsDirectory() {
        File file = new File(this.x, r);
        ensureDirectoryExists(file);
        return file;
    }

    public File getUserFontDirectory() {
        File file = new File(this.x, q);
        ensureDirectoryExists(file);
        return file;
    }

    public File getSystemFontFileZh() {
        return (File) this.G.a();
    }

    public File getSystemFontFileEn() {
        return (File) this.H.a();
    }

    public final File getExternalFilesDirectory() {
        return this.x;
    }

    public final synchronized File getSecondaryFilesDirectory() {
        return this.z;
    }

    public synchronized File[] getExternalFilesDirectories() {
        return this.x.equals(this.z) ? new File[]{this.x} : new File[]{this.x, this.z};
    }

    public final synchronized void setSecondaryStorageDirectory(File file) {
        if (file != null) {
            setPrefString(PrivatePref.PERSONAL, "storage", file.getAbsolutePath());
            commitPrefs();
            this.z = secondaryFilesDir(this.x);
            ensureDirectoryExists(this.z);
            this.A = null;
            this.B = null;
            this.C = null;
        }
    }

    public int getVersionCode() {
        int i = 0;
        try {
            return this.b.getPackageManager().getPackageInfo(this.b.getPackageName(), 0).versionCode;
        } catch (Throwable th) {
            return i;
        }
    }

    public synchronized int getFirstVersionCode() {
        return this.u.getInt("global__first_version_code", 0);
    }

    public synchronized int getLastVersionCode() {
        return this.u.getInt("global__last_version_code", 0);
    }

    public synchronized String getVersionName() {
        String str;
        try {
            str = this.b.getPackageManager().getPackageInfo(this.b.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            str = "1.7.0";
        }
        return str;
    }

    public synchronized String getDistChannel() {
        return this.u.getString("global__dist_channel", "");
    }

    public synchronized int getDeviceIdVersion() {
        int i;
        if (getFirstVersionCode() < 84) {
            i = 1;
        } else if (getFirstVersionCode() < 240000000) {
            i = 2;
        } else {
            i = 3;
        }
        return i;
    }

    public synchronized boolean getShowAppStoreGuide() {
        return this.u.getBoolean("global__app_store_guide", false);
    }

    public synchronized void setShowAppStoreGuide(boolean z) {
        getPrefsEditor().putBoolean("global__app_store_guide", z);
        commitPrefs();
    }

    public synchronized int getLastUseDay() {
        return this.u.getInt("global__last_use_day", 0);
    }

    public synchronized void setLastUseDay(int i) {
        getPrefsEditor().putInt("global__last_use_day", i);
        commitPrefs();
    }

    public synchronized int getUseDays() {
        return this.u.getInt("global__use_days", 0);
    }

    public synchronized void setUseDays(int i) {
        getPrefsEditor().putInt("global__use_days", i);
        commitPrefs();
    }

    public synchronized long getAdvancedActionTime() {
        return this.u.getLong("global__advanced_action_time", 0);
    }

    public synchronized void setAdvancedActionTime(long j) {
        getPrefsEditor().putLong("global__advanced_action_time", j);
        commitPrefs();
    }

    public boolean getShowPurchasedHint() {
        if (DkApp.get().activateFromLauncher()) {
            return this.u.getBoolean("global__show_purchased_hint", true);
        }
        return false;
    }

    public void setShowPurchasedHint(boolean z) {
        getPrefsEditor().putBoolean("global__show_purchased_hint", z);
        commitPrefs();
    }

    public synchronized int getDefaultReadingFontSize() {
        return com.duokan.common.i.a(this.b, 18.0f);
    }

    public synchronized boolean isExternalStorageMounted() {
        boolean z;
        if (Environment.getExternalStorageState().equals("mounted")) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public void setAppActivated() {
        getPrefsEditor().putBoolean("global__app_activated", true);
        commitPrefs();
    }

    public boolean isFreshInstall() {
        return this.u.getBoolean("global__fresh_install", true);
    }

    public boolean needAddNewbieBook() {
        return this.u.getBoolean("global__need_add_newbie_book", false);
    }

    public void setNeedAddNewbieBook(boolean z) {
        getPrefsEditor().putBoolean("global__need_add_newbie_book", z);
        commitPrefs();
    }

    public synchronized boolean isFirstCloudSync() {
        return this.u.getBoolean("global__first_cloud_sync", true);
    }

    public synchronized void setIsFirstCloudSync(boolean z) {
        getPrefsEditor().putBoolean("global__first_cloud_sync", z);
        commitPrefs();
    }

    public String getKernelVersion() {
        return "3.2.1.170324";
    }

    public boolean hasPhysicalBackKey() {
        return KeyCharacterMap.deviceHasKey(4);
    }

    public synchronized String getBuildName() {
        return this.b.getString(com.duokan.b.i.app__shared__build_name);
    }

    public synchronized Class loadExtendClass(String str) {
        return loadExtendClass(str, extendLibraryFile());
    }

    public synchronized Class loadExtendCompatClass(String str) {
        return loadExtendClass(str, extendLibraryCompatFile());
    }

    private synchronized Class loadExtendClass(String str, File file) {
        Class loadClass;
        boolean z = true;
        synchronized (this) {
            try {
                ClassLoader classLoader;
                boolean z2;
                if (this.F.containsKey(file)) {
                    classLoader = (ClassLoader) this.F.get(file);
                } else if (VERSION.SDK_INT >= 21) {
                    classLoader = new DexClassLoader(file.getAbsolutePath(), this.b.getCodeCacheDir().getAbsolutePath(), this.b.getApplicationInfo().dataDir + "/lib", getClass().getClassLoader());
                } else {
                    classLoader = new DexClassLoader(file.getAbsolutePath(), this.b.getCacheDir().getAbsolutePath(), this.b.getApplicationInfo().dataDir + "/lib", getClass().getClassLoader());
                }
                loadClass = classLoader.loadClass(str);
                com.duokan.core.diagnostic.a c = com.duokan.core.diagnostic.a.c();
                if (loadClass != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                c.b(z2);
                if (loadClass != null) {
                    if (!this.F.containsKey(file)) {
                        this.F.put(file, classLoader);
                    }
                }
            } catch (Throwable th) {
                com.duokan.core.diagnostic.a.c().a(LogLevel.ERROR, "env", String.format("fail to load extend class(class=%s, file=%s)", new Object[]{str, file}), th);
            }
            try {
                ClassLoader pathClassLoader = new PathClassLoader(file.getAbsolutePath(), this.b.getApplicationInfo().dataDir + "/lib", getClass().getClassLoader());
                loadClass = pathClassLoader.loadClass(str);
                com.duokan.core.diagnostic.a c2 = com.duokan.core.diagnostic.a.c();
                if (loadClass == null) {
                    z = false;
                }
                c2.b(z);
                if (loadClass != null) {
                    if (!this.F.containsKey(file)) {
                        this.F.put(file, pathClassLoader);
                    }
                }
            } catch (Throwable th2) {
                com.duokan.core.diagnostic.a.c().a(LogLevel.ERROR, "env", String.format("fail to load extend class(class=%s, file=%s)", new Object[]{str, file}), th2);
            }
            loadClass = null;
        }
        return loadClass;
    }

    public Drawable getOldPaperDrawable() {
        return (Drawable) this.I.a();
    }

    public boolean onMiui() {
        return z.a();
    }

    public boolean isVipDevice() {
        return TextUtils.equals(Build.MANUFACTURER, "Xiaomi") && (TextUtils.equals("Mi Note 2", SystemProperties.get("ro.product.model")) || TextUtils.equals("MIX", SystemProperties.get("ro.product.model")));
    }

    public boolean onHongMi() {
        if (this.v.b()) {
            return ((Boolean) this.v.a()).booleanValue();
        }
        try {
            Class cls = Class.forName("miui.os.Build");
            if (cls != null) {
                this.v.a(Boolean.valueOf(cls.getDeclaredField("IS_HONGMI").getBoolean(null)));
                return ((Boolean) this.v.a()).booleanValue();
            }
            this.v.a(Boolean.valueOf(false));
            return false;
        } catch (Throwable th) {
            if (Build.MANUFACTURER.contains("Xiaomi") && Build.DEVICE.startsWith("HM")) {
                this.v.a(Boolean.valueOf(true));
                return true;
            }
            this.v.a(Boolean.valueOf(false));
            return false;
        }
    }

    public synchronized String getPrefString(PrivatePref privatePref, String str, String str2) {
        return this.u.getString(getPrefKey(privatePref, str), str2);
    }

    public synchronized void setPrefString(PrivatePref privatePref, String str, String str2) {
        getPrefsEditor().putString(getPrefKey(privatePref, str), str2);
    }

    public synchronized long getPrefLong(PrivatePref privatePref, String str, long j) {
        return this.u.getLong(getPrefKey(privatePref, str), j);
    }

    public synchronized void setPrefLong(PrivatePref privatePref, String str, long j) {
        getPrefsEditor().putLong(getPrefKey(privatePref, str), j);
    }

    public synchronized int getPrefInt(PrivatePref privatePref, String str, int i) {
        return this.u.getInt(getPrefKey(privatePref, str), i);
    }

    public synchronized void setPrefInt(PrivatePref privatePref, String str, int i) {
        getPrefsEditor().putInt(getPrefKey(privatePref, str), i);
    }

    public synchronized float getPrefFloat(PrivatePref privatePref, String str, float f) {
        return this.u.getFloat(getPrefKey(privatePref, str), f);
    }

    public synchronized void setPrefFloat(PrivatePref privatePref, String str, float f) {
        getPrefsEditor().putFloat(getPrefKey(privatePref, str), f);
    }

    public synchronized boolean getPrefBoolean(PrivatePref privatePref, String str, boolean z) {
        return this.u.getBoolean(getPrefKey(privatePref, str), z);
    }

    public synchronized void setPrefBoolean(PrivatePref privatePref, String str, boolean z) {
        getPrefsEditor().putBoolean(getPrefKey(privatePref, str), z);
    }

    public synchronized void removePrefKey(PrivatePref privatePref, String str) {
        getPrefsEditor().remove(getPrefKey(privatePref, str));
    }

    public synchronized boolean hasPrefKey(PrivatePref privatePref, String str) {
        return this.u.contains(getPrefKey(privatePref, str));
    }

    public synchronized void commitPrefs() {
        if (this.D != null) {
            this.D.apply();
            this.D = null;
        }
    }

    public static synchronized void startup(DkApp dkApp) {
        synchronized (ReaderEnv.class) {
            if (a == null) {
                a = new ReaderEnv(dkApp);
            }
        }
    }

    public static synchronized ReaderEnv get() {
        ReaderEnv readerEnv;
        synchronized (ReaderEnv.class) {
            if (c || a != null) {
                readerEnv = a;
            } else {
                throw new AssertionError();
            }
        }
        return readerEnv;
    }

    public final boolean forHd() {
        return this.b.forHd();
    }

    public final String getAppName() {
        return this.t;
    }

    public String getAppId() {
        return this.b.getAppId();
    }

    public String getAppIdforStore() {
        return this.b.getAppIdforStore();
    }

    public String getDeviceId() {
        if (getFirstVersionCode() < 84) {
            return getOldDeviceId();
        }
        if (getFirstVersionCode() < 240000000) {
            return getNewDeviceId();
        }
        return DkUtils.getDeviceId();
    }

    public synchronized String getDeviceType() {
        String str;
        str = "";
        try {
            str = Build.MODEL;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public synchronized boolean getSyncEnabled() {
        return this.u.getBoolean("global__sync_enabled", true);
    }

    public synchronized void setSyncEnabled(boolean z) {
        getPrefsEditor().putBoolean("global__sync_enabled", z);
        commitPrefs();
    }

    public synchronized boolean getSyncBookshelfEnabled() {
        return this.u.getBoolean("global__sync_enabled", true);
    }

    public synchronized boolean getSyncEvernoteEnabled() {
        return this.u.getBoolean("global__sync_evernote", false);
    }

    public synchronized void setSyncEvernoteEnabled(boolean z) {
        getPrefsEditor().putBoolean("global__sync_evernote", z);
        commitPrefs();
    }

    public synchronized boolean getIsOnlyWifiSyncEvernote() {
        return this.u.getBoolean("global__only_wifi_sync_evernote", true);
    }

    public synchronized void setIsOnlyWifiSyncEvernote(boolean z) {
        getPrefsEditor().putBoolean("global__only_wifi_sync_evernote", z);
        commitPrefs();
    }

    public synchronized boolean getIsOnlyWifiUploadDownload() {
        return true;
    }

    public synchronized void setReceiveReplyMessage(boolean z) {
        getPrefsEditor().putBoolean("global__receive_reply", z);
        commitPrefs();
    }

    public synchronized boolean getIsReceiveReplyMessage() {
        return this.u.getBoolean("global__receive_reply", true);
    }

    public void addOnReaderPrefChangedListener(PrivatePref privatePref, OnReaderPrefChangedListener onReaderPrefChangedListener) {
        if (!this.J.contains(privatePref)) {
            this.J.putIfAbsent(privatePref, new CopyOnWriteArrayList());
        }
        ((CopyOnWriteArrayList) this.J.get(privatePref)).addIfAbsent(onReaderPrefChangedListener);
    }

    public synchronized void setUpdatePushStatus(boolean z) {
        getPrefsEditor().putBoolean("global__update_push_status", z);
        commitPrefs();
    }

    public synchronized boolean getUpdatePushStatus() {
        return this.u.getBoolean("global__update_push_status", false);
    }

    public synchronized boolean getReceivePushes() {
        return this.u.getBoolean("global__receive_pushes", true);
    }

    public synchronized void setReceivePushes(boolean z) {
        getPrefsEditor().putBoolean("global__receive_pushes", z);
        commitPrefs();
    }

    public synchronized int getNewVersion() {
        return this.u.getInt("global__new_version_code", getVersionCode());
    }

    public synchronized void setNewVersion(int i) {
        getPrefsEditor().putInt("global__new_version_code", i);
        commitPrefs();
    }

    public synchronized long getLastDetectUpdateTime() {
        return this.u.getLong("global__last_detect_update_time", -1);
    }

    public synchronized void setLastDetectUpdateTime(long j) {
        getPrefsEditor().putLong("global__last_detect_update_time", j);
        commitPrefs();
    }

    public synchronized boolean getKeepReading() {
        return this.u.getBoolean("global__keep_reading", false);
    }

    public synchronized void setKeepReading(boolean z) {
        getPrefsEditor().putBoolean("global__keep_reading", z);
        commitPrefs();
    }

    public synchronized String getReadingBookUuid() {
        return this.u.getString("global__reading_book_uuid", "");
    }

    public synchronized void setReadingBookUuid(String str) {
        getPrefsEditor().putString("global__reading_book_uuid", str);
        commitPrefs();
    }

    public synchronized long getLastShowStoreDay() {
        return this.u.getLong("global__last_show_store_day", 0);
    }

    public synchronized long updateLastShowStoreDay() {
        long currentTimeMillis;
        currentTimeMillis = (System.currentTimeMillis() + ((long) TimeZone.getDefault().getRawOffset())) / 86400000;
        getPrefsEditor().putLong("global__last_show_store_day", currentTimeMillis);
        commitPrefs();
        return currentTimeMillis;
    }

    public synchronized long getLastCommentTime() {
        return this.u.getLong("global__last_comment_time", 0);
    }

    public synchronized void setLastCommentTime(long j) {
        getPrefsEditor().putLong("global__last_comment_time", j);
        commitPrefs();
    }

    public synchronized Set getMarketCDNIpOnWifi() {
        return this.u.getStringSet("global__market_cdn_ip_on_wifi", new HashSet());
    }

    public synchronized void setMarketCDNIpOnWifi(Set set) {
        getPrefsEditor().putStringSet("global__market_cdn_ip_on_wifi", set);
        commitPrefs();
    }

    public synchronized Set getMarketCDNIpOnWap() {
        return this.u.getStringSet("global__market_cdn_ip_on_wap", new HashSet());
    }

    public synchronized void setMarketCDNIpOnWap(Set set) {
        getPrefsEditor().putStringSet("global__market_cdn_ip_on_wap", set);
        commitPrefs();
    }

    public synchronized long getLastGetCDNIpTime() {
        return this.u.getLong("global__last_get_cdn_ip_date", 0);
    }

    public synchronized void setLastGetCDNIpTime(long j) {
        getPrefsEditor().putLong("global__last_get_cdn_ip_date", j);
        commitPrefs();
    }

    public synchronized BookshelfItemStyle getBookshelfItemStyle() {
        BookshelfItemStyle bookshelfItemStyle;
        bookshelfItemStyle = BookshelfItemStyle.SIMPLE;
        try {
            bookshelfItemStyle = BookshelfItemStyle.valueOf(this.u.getString("global__bookshelf_item_style", BookshelfItemStyle.SIMPLE.name()));
        } catch (Throwable th) {
        }
        return bookshelfItemStyle;
    }

    public synchronized void setBookshelfItemStyle(BookshelfItemStyle bookshelfItemStyle) {
        if (getBookshelfItemStyle() != bookshelfItemStyle) {
            getPrefsEditor().putString("global__bookshelf_item_style", bookshelfItemStyle.name());
            commitPrefs();
            if (this.L != null) {
                this.L.onBookshelfItemStyleChanged(bookshelfItemStyle);
            }
        }
    }

    public synchronized void setOnBookshelfItemStyleChangedListener(OnBookshelfItemStyleChangedListener onBookshelfItemStyleChangedListener) {
        this.L = onBookshelfItemStyleChangedListener;
    }

    public synchronized boolean getIsWifiAutoDownloadFontAble() {
        return this.u.getBoolean("global__wifi_auto_download_font", false);
    }

    public synchronized void setIsWifiAutoDownloadFontAble(boolean z) {
        getPrefsEditor().putBoolean("global__wifi_auto_download_font", z);
        commitPrefs();
    }

    public synchronized long getLastShowLoginDialogInAnonymousTime() {
        return this.u.getLong("global__show_login_dialog_in_anoymous_account", 0);
    }

    public synchronized void setLastShowLoginDialogInAnonymousTime(long j) {
        getPrefsEditor().putLong("global__show_login_dialog_in_anoymous_account", j);
        commitPrefs();
    }

    public synchronized int getBookOpenTimes() {
        return this.u.getInt("global__opened_books", 0);
    }

    public synchronized void addBookOpenTimes() {
        getPrefsEditor().putInt("global__opened_books", getBookOpenTimes() + 1);
        commitPrefs();
    }

    public synchronized void setIcibaNetworkingEnabled(boolean z) {
        getPrefsEditor().putBoolean("iciba_enable_network", z);
        commitPrefs();
    }

    public synchronized boolean getIcibaNetworkingEnabled() {
        return this.u.getBoolean("iciba_enable_network", true);
    }

    public synchronized long getUpdateDownloadTaskId() {
        return this.u.getLong("global__update_download_task_id", -1);
    }

    public synchronized void setUpdateDownloadTaskId(long j) {
        getPrefsEditor().putLong("global__update_download_task_id", j);
        commitPrefs();
    }

    public synchronized a getDb() {
        return this.E;
    }

    public synchronized void addOnBookShelfTypeChangedListener(OnBookShelfTypeChangedListener onBookShelfTypeChangedListener) {
        this.K.add(onBookShelfTypeChangedListener);
    }

    public synchronized void removeOnBookShelfTypeChangedListener(OnBookShelfTypeChangedListener onBookShelfTypeChangedListener) {
        this.K.remove(onBookShelfTypeChangedListener);
    }

    public synchronized BookShelfType getBookShelfType() {
        BookShelfType valueOf;
        try {
            valueOf = BookShelfType.valueOf(this.u.getString("global__bookshelf_type", ""));
        } catch (Exception e) {
            valueOf = BookShelfType.Simple;
        }
        return valueOf;
    }

    public synchronized void setBookShelfType(BookShelfType bookShelfType) {
        getPrefsEditor().putString("global__bookshelf_type", bookShelfType.toString());
        commitPrefs();
        Iterator it = this.K.iterator();
        while (it.hasNext()) {
            ((OnBookShelfTypeChangedListener) it.next()).onBookShelfTypeChanged(bookShelfType);
        }
    }

    public synchronized int getShoppingCartSituation() {
        return this.u.getInt("global__shopping_cart_situation", 2);
    }

    public synchronized void setShoppingCartSituation(int i) {
        getPrefsEditor().putInt("global__shopping_cart_situation", i);
        commitPrefs();
    }

    public int getUserGender() {
        return this.u.getInt("global__user_gender", -1);
    }

    public synchronized boolean getIsSendNow() {
        return this.u.getBoolean("global__send_now", true);
    }

    public synchronized void setIsSendNow(boolean z) {
        getPrefsEditor().putBoolean("global__send_now", z);
        commitPrefs();
    }

    public void onRunningStateChanged(ManagedApp managedApp, RunningState runningState, RunningState runningState2) {
        if (runningState2 == RunningState.BACKGROUND) {
            commitPrefs();
        }
    }

    private String getNewDeviceId() {
        String[] genDeviceIds = genDeviceIds(new String[]{getMacAddress(), getAndroidId()});
        if (c || genDeviceIds.length > 0) {
            String cachedDeviceId = getCachedDeviceId();
            if (TextUtils.isEmpty(cachedDeviceId)) {
                String chooseDeviceId = chooseDeviceId(genDeviceIds);
                setCachedDeviceId(chooseDeviceId);
                return chooseDeviceId;
            }
            int intValue;
            try {
                intValue = Integer.valueOf(cachedDeviceId.substring(4, 5)).intValue();
            } catch (Exception e) {
                e.printStackTrace();
                intValue = 1;
            }
            intValue = Math.max(1, Math.min(intValue, genDeviceIds.length));
            if (TextUtils.isEmpty(genDeviceIds[intValue - 1])) {
                return cachedDeviceId;
            }
            return genDeviceIds[intValue - 1];
        }
        throw new AssertionError();
    }

    private String getOldDeviceId() {
        Object obj = null;
        try {
            obj = ((TelephonyManager) this.b.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(obj)) {
            try {
                obj = ((WifiManager) this.b.getSystemService("wifi")).getConnectionInfo().getMacAddress();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(obj)) {
            try {
                Class cls = Class.forName("android.os.SystemProperties");
                obj = (String) cls.getMethod("get", new Class[]{String.class, String.class}).invoke(cls, new Object[]{"ro.serialno", null});
            } catch (Exception e22) {
                e22.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(obj)) {
            try {
                obj = Secure.getString(this.b.getContentResolver(), "android_id");
            } catch (Exception e222) {
                e222.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(obj)) {
            return "";
        }
        return this.b.getDeviceIdPrefix() + obj;
    }

    private void prepareInternalFiles() {
        if (!this.y.exists()) {
            com.duokan.core.diagnostic.a.c().a(LogLevel.EVENT, "env", "preparing internal files...(ver=%getScaledTouchSlop)", Integer.valueOf(17));
            int i = 0;
            while (i < 3) {
                File file = new File(this.w, "res.v17.arch");
                com.duokan.core.io.a.d(file);
                File file2 = new File(this.y.getAbsolutePath() + ".tmp");
                com.duokan.core.io.a.d(file2);
                file2.mkdirs();
                OutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    DkPublic.extractRawResource(this.b, fileOutputStream, h.raw__shared__res_files);
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (Throwable th) {
                    }
                    DkarchLib.extract(file.getAbsolutePath(), file2.getAbsolutePath());
                    com.duokan.core.io.a.d(this.y);
                    if (file2.renameTo(this.y)) {
                        com.duokan.core.diagnostic.a.c().a(LogLevel.EVENT, "env", "internal files are ready(ver=%getScaledTouchSlop)", Integer.valueOf(17));
                        com.duokan.core.io.a.d(file);
                        com.duokan.core.io.a.d(file2);
                        return;
                    }
                    com.duokan.core.diagnostic.a.c().a(LogLevel.ERROR, "env", "can'TaskHandler move internal files in place(ver=%getScaledTouchSlop)", Integer.valueOf(17));
                    com.duokan.core.io.a.d(file);
                    com.duokan.core.io.a.d(file2);
                    j.a(3000);
                    i++;
                } catch (Throwable th2) {
                    try {
                        com.duokan.core.diagnostic.a.c().a(LogLevel.ERROR, "env", String.format("an exception occurs while preparing internal files(ver=%getScaledTouchSlop)", new Object[]{Integer.valueOf(17)}), th2);
                    } finally {
                        com.duokan.core.io.a.d(file);
                        com.duokan.core.io.a.d(file2);
                    }
                }
            }
        }
    }

    private void ensureDirectoryExists(File file) {
        if (file != null && !file.exists()) {
            file.mkdirs();
        }
    }

    protected String getCachedDeviceId() {
        return this.u.getString("global__cached_device_id", "");
    }

    protected void setCachedDeviceId(String str) {
        getPrefsEditor().putString("global__cached_device_id", str);
    }

    private Editor getPrefsEditor() {
        if (this.D == null) {
            this.D = this.u.edit();
        }
        return this.D;
    }

    private String getPrefKey(PrivatePref privatePref, String str) {
        return (privatePref.toString() + "__" + str).toLowerCase();
    }

    private String chooseDeviceId(String[] strArr) {
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        if (c) {
            return "";
        }
        throw new AssertionError();
    }

    private String[] genDeviceIds(String[] strArr) {
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr2.length; i++) {
            if (TextUtils.isEmpty(strArr[i])) {
                strArr2[i] = "";
            } else {
                strArr2[i] = String.format(this.b.getDeviceIdPrefix() + "%d00%s", new Object[]{Integer.valueOf(i + 1), o.a(strArr[i], "utf-16", "md5")});
            }
        }
        return strArr2;
    }

    private String getMacAddress() {
        String str = "";
        try {
            return ((WifiManager) this.b.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    private String getAndroidId() {
        String str = "";
        try {
            str = Secure.getString(this.b.getContentResolver(), "android_id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    private File extendLibraryFile() {
        return new File(this.y, d + File.separator + "ext_lib.apk");
    }

    private File extendLibraryCompatFile() {
        return new File(this.y, d + File.separator + "ext_lib_comp.apk");
    }

    private File sysFontFileEn() {
        for (String file : new String[]{"/system/fonts/Roboto-Regular.ttf", "/system/fonts/DroidSans.ttf", "/system/fonts/NotoSerif-Regular.ttf"}) {
            File file2 = new File(file);
            if (file2.exists()) {
                return file2;
            }
        }
        return sysFontFileZh();
    }

    private File sysFontFileZh() {
        File file;
        for (String file2 : onMiui() ? new String[]{"/data/system/theme/fonts/DroidSansFallback.ttf", "/data/system/theme/fonts/Miui-Regular.ttf", "/system/fonts/Miui-Regular.ttf", "/system/fonts/DroidSansFallbackMiuiMissing.ttf"} : new String[]{"/system/fonts/HwChinese-Regular.ttf", "/system/fonts/HwChinese-Medium.ttf", "/system/fonts/VivoFont.ttf"}) {
            File file3 = new File(file2);
            if (file3.exists() && DkUtils.isZhFont(file3.getAbsolutePath())) {
                return file3;
            }
        }
        if (VERSION.SDK_INT >= 23) {
            for (String file22 : new String[]{"/system/fonts/NotoSansCJK.ttc", "/system/fonts/NotoSansCJK-Regular.ttc", "/system/fonts/NotoSansCJKsc-Regular.otf", "/system/fonts/NotoSansSC-Regular.otf"}) {
                file = new File(file22);
                if (file.exists()) {
                    return file;
                }
            }
        }
        List<File> a = com.duokan.core.io.a.a(new File("/system/fonts"), new FileFilter[0]);
        Collections.sort(a, new Comparator(this) {
            final /* synthetic */ ReaderEnv a;

            {
                this.a = r1;
            }

            public int compare(File file, File file2) {
                long length = file.length() - file2.length();
                if (length > 0) {
                    return -1;
                }
                return length < 0 ? 1 : 0;
            }
        });
        for (File file4 : a) {
            if (DkUtils.isZhFont(file4.getAbsolutePath())) {
                return file4;
            }
        }
        com.duokan.core.diagnostic.a.c().b();
        return new File("/system/fonts", "DroidSansFallback.ttf");
    }

    private File secondaryFilesDir(File file) {
        Object prefString = getPrefString(PrivatePref.PERSONAL, "storage", "");
        if (TextUtils.isEmpty(prefString)) {
            return file;
        }
        File file2 = new File(prefString);
        return (file2.canRead() && file2.canWrite() && file2.getFreeSpace() > 0) ? new File(file2, this.t) : file;
    }

    private static void configHttps() {
        try {
            TrustManager[] trustManagerArr = new TrustManager[]{new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
                }

                public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
                }
            }};
            SSLContext instance = SSLContext.getInstance("SSL");
            instance.init(null, trustManagerArr, new SecureRandom());
            HostnameVerifier anonymousClass6 = new HostnameVerifier() {
                public boolean verify(String str, SSLSession sSLSession) {
                    return true;
                }
            };
            HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(anonymousClass6);
        } catch (Throwable th) {
        }
    }
}
