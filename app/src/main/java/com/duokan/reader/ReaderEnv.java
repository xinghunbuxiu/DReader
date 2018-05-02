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
import com.duokan.common.C0267i;
import com.duokan.core.app.C0286x;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.io.FileUtil;
import com.duokan.core.p026a.C0272a;
import com.duokan.core.sys.C0299i;
import com.duokan.core.sys.UIdleHandler;
import com.duokan.core.sys.C0366o;
import com.duokan.core.sys.C0373z;
import com.duokan.core.sys.af;
import com.duokan.core.sys.ah;
import com.duokan.kernel.DkUtils;
import com.duokan.lib.archive.DkarchLib;
import com.duokan.p023b.C0243e;
import com.duokan.p023b.C0246h;
import com.duokan.p023b.C0247i;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
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
import miuipub.os.SystemProperties;

public class ReaderEnv implements C0286x {
    /* renamed from: a */
    protected static ReaderEnv f1597a = null;
    /* renamed from: c */
    static final /* synthetic */ boolean f1598c;
    /* renamed from: d */
    private static final String f1599d = (File.separator + "lib");
    /* renamed from: e */
    private static final String f1600e = (File.separator + "www");
    /* renamed from: f */
    private static final String f1601f = ("DkKernel" + File.separator + "Resource" + File.separator + "WordSeg");
    /* renamed from: g */
    private static final String f1602g = ("DkKernel" + File.separator + "Resource" + File.separator + "Font");
    /* renamed from: h */
    private static final String f1603h = (File.separator + "Cache");
    /* renamed from: i */
    private static final String f1604i = (f1603h + File.separator + "temp");
    /* renamed from: j */
    private static final String f1605j = (File.separator + "Downloads");
    /* renamed from: k */
    private static final String f1606k = (f1605j + File.separator + "Cloud");
    /* renamed from: l */
    private static final String f1607l = (f1605j + File.separator + "Local");
    /* renamed from: m */
    private static final String f1608m = (f1605j + File.separator + "WiFi");
    /* renamed from: n */
    private static final String f1609n = (f1605j + File.separator + "Covers");
    /* renamed from: o */
    private static final String f1610o = (f1605j + File.separator + "CloudPrivateBooks");
    /* renamed from: p */
    private static final String f1611p = (f1605j + File.separator + "MiCloudBooks");
    /* renamed from: q */
    private static final String f1612q = (File.separator + "Resource" + File.separator + "Font");
    /* renamed from: r */
    private static final String f1613r = (File.separator + "Plugins");
    /* renamed from: s */
    private static final String f1614s = (f1613r + File.separator + "Dict");
    /* renamed from: A */
    private File f1615A = null;
    /* renamed from: B */
    private File f1616B = null;
    /* renamed from: C */
    private File f1617C = null;
    /* renamed from: D */
    private Editor f1618D = null;
    /* renamed from: E */
    private final C0272a f1619E;
    /* renamed from: F */
    private final HashMap<File, ClassLoader> f1620F = new HashMap();
    /* renamed from: G */
    private final C0299i<File> f1621G = new C0299i();
    /* renamed from: H */
    private final C0299i<File> f1622H = new C0299i();
    /* renamed from: I */
    private final C0299i<Drawable> f1623I = new C0299i();
    /* renamed from: J */
    private final ConcurrentHashMap<PrivatePref, CopyOnWriteArrayList<OnReaderPrefChangedListener>> f1624J = new ConcurrentHashMap();
    /* renamed from: K */
    private final CopyOnWriteArrayList<OnBookShelfTypeChangedListener> f1625K = new CopyOnWriteArrayList();
    /* renamed from: L */
    private OnBookshelfItemStyleChangedListener f1626L = null;
    /* renamed from: b */
    protected final DkApp f1627b;
    /* renamed from: t */
    private final String f1628t;
    /* renamed from: u */
    private final SharedPreferences f1629u;
    /* renamed from: v */
    private final af<Boolean> f1630v = new af();
    /* renamed from: w */
    private final File f1631w;
    /* renamed from: x */
    private final File f1632x;
    /* renamed from: y */
    private final File f1633y;
    /* renamed from: z */
    private File f1634z = null;

    /* renamed from: com.duokan.reader.ReaderEnv$1 */
    class C04791 implements OnSharedPreferenceChangeListener {
        /* renamed from: a */
        final /* synthetic */ ReaderEnv f1593a;

        C04791(ReaderEnv readerEnv) {
            this.f1593a = readerEnv;
        }

        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            try {
                String[] split = str.split("__");
                PrivatePref valueOf = PrivatePref.valueOf(split[0].toUpperCase(Locale.US));
                String str2 = split[1];
                CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.f1593a.f1624J.get(valueOf);
                if (copyOnWriteArrayList != null) {
                    Iterator it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        ((OnReaderPrefChangedListener) it.next()).onReaderPrefChanged(valueOf, str2);
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: com.duokan.reader.ReaderEnv$2 */
    class C04802 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ ReaderEnv f1594a;

        C04802(ReaderEnv readerEnv) {
            this.f1594a = readerEnv;
        }

        public void run() {
            File access$100 = this.f1594a.sysFontFileZh();
            File access$200 = this.f1594a.sysFontFileEn();
            this.f1594a.f1621G.m708a(access$100);
            this.f1594a.f1622H.m708a(access$200);
            this.f1594a.f1623I.m708a(this.f1594a.f1627b.getResources().getDrawable(C0243e.reading__reading_themes_vine_yellow_shadow));
            this.f1594a.prepareInternalFiles();
            if (!this.f1594a.f1634z.equals(this.f1594a.f1632x)) {
                Object obj;
                for (File access$1002 : FileUtil.getAllFile(this.f1594a.f1627b)) {
                    if (this.f1594a.f1634z.getParentFile().equals(access$1002)) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    this.f1594a.setSecondaryStorageDirectory(this.f1594a.f1632x.getParentFile());
                }
            }
        }
    }

    /* renamed from: com.duokan.reader.ReaderEnv$3 */
    class C04813 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ ReaderEnv f1595a;

        C04813(ReaderEnv readerEnv) {
            this.f1595a = readerEnv;
        }

        public void run() {
            this.f1595a.f1627b.addOnRunningStateChangedListener(this.f1595a);
        }
    }

    /* renamed from: com.duokan.reader.ReaderEnv$4 */
    class C04824 implements Comparator<File> {
        /* renamed from: a */
        final /* synthetic */ ReaderEnv f1596a;

        C04824(ReaderEnv readerEnv) {
            this.f1596a = readerEnv;
        }

        public int compare(File file, File file2) {
            long length = file.length() - file2.length();
            if (length > 0) {
                return -1;
            }
            return length < 0 ? 1 : 0;
        }
    }

    /* renamed from: com.duokan.reader.ReaderEnv$5 */
    final class C04835 implements X509TrustManager {
        C04835() {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }
    }

    /* renamed from: com.duokan.reader.ReaderEnv$6 */
    final class C04846 implements HostnameVerifier {
        C04846() {
        }

        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

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
        f1598c = z;
    }

    public ReaderEnv(DkApp dkApp) {
        configHttps();
        this.f1627b = dkApp;
        this.f1628t = this.f1627b.getAppName();
        this.f1629u = dkApp.getSharedPreferences("env", 0);
        this.f1629u.registerOnSharedPreferenceChangeListener(new C04791(this));
        this.f1631w = this.f1627b.getFilesDir();
        this.f1632x = new File(Environment.getExternalStorageDirectory(), this.f1628t);
        this.f1633y = new File(this.f1631w, "res.v17");
        this.f1634z = secondaryFilesDir(this.f1632x);
        int i = this.f1629u.getInt("global__version_code", 0);
        if (this.f1629u.contains("global__app_activated")) {
            getPrefsEditor().putBoolean("global__fresh_install", false);
        } else {
            boolean z;
            if (!this.f1629u.contains("global__first_version_code")) {
                getPrefsEditor().putInt("global__first_version_code", i == 0 ? getVersionCode() : i);
            }
            Editor prefsEditor = getPrefsEditor();
            String str = "global__fresh_install";
            if (new File(this.f1632x, f1605j).exists()) {
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
                    ((DownloadManager) this.f1627b.getSystemService("download")).remove(new long[]{getUpdateDownloadTaskId()});
                } catch (Exception e) {
                }
                setUpdateDownloadTaskId(-1);
            }
        }
        if (!TextUtils.isEmpty(DkPublic.getDkDistChannel(this.f1627b)) && TextUtils.isEmpty(this.f1629u.getString("global__dist_channel", ""))) {
            getPrefsEditor().putString("global__dist_channel", DkPublic.getDkDistChannel(this.f1627b));
        }
        ensureDirectoryExists(this.f1631w);
        ensureDirectoryExists(this.f1632x);
        ensureDirectoryExists(this.f1634z);
        this.f1619E = new C0272a(Uri.fromFile(new File(getDatabaseDirectory(), "reader.db")).toString());
        if (i < 413000000 && this.f1634z.compareTo(this.f1632x) != 0) {
            File[] fileArr = (File[]) FileUtil.getAllFile(this.f1627b).toArray(new File[0]);
            File file = fileArr[fileArr.length - 1];
            setPrefString(PrivatePref.PERSONAL, "storage", file.getAbsolutePath());
            this.f1634z = new File(file, this.f1628t);
            ensureDirectoryExists(this.f1634z);
        }
        ah.m865a(new C04802(this));
        commitPrefs();
        this.f1627b.runPreReady(new C04813(this));
    }

    public Application getApplication() {
        return this.f1627b;
    }

    public Resources getResources() {
        return this.f1627b.getApplicationContext().getResources();
    }

    public boolean isWebAccessEnabled() {
        return this.f1627b.isWebAccessEnabled();
    }

    public File getWwwDirectory() {
        return new File(this.f1633y, f1600e);
    }

    public File getDatabaseDirectory() {
        File parentFile = this.f1627b.getDatabasePath("name").getParentFile();
        ensureDirectoryExists(parentFile);
        return parentFile;
    }

    public File getKernelDirectory() {
        return new File(this.f1633y, "DkKernel");
    }

    public File getKernelFontDirectory() {
        return new File(this.f1633y, f1602g);
    }

    public File getCacheDirectory() {
        File file = new File(this.f1632x, f1603h);
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
        File cacheDir = this.f1627b.getCacheDir();
        ensureDirectoryExists(cacheDir);
        return cacheDir;
    }

    public File getTempDirectory() {
        File file = new File(this.f1632x, f1604i);
        ensureDirectoryExists(file);
        return file;
    }

    public File getLocalBookDirectory() {
        File file = new File(this.f1632x, f1607l);
        ensureDirectoryExists(file);
        return file;
    }

    public File getWiFiDirectory() {
        File file = new File(this.f1634z, f1608m);
        ensureDirectoryExists(file);
        return file;
    }

    public File[] getWiFiDirectories() {
        File[] externalFilesDirectories = getExternalFilesDirectories();
        File[] fileArr = new File[externalFilesDirectories.length];
        for (int i = 0; i < externalFilesDirectories.length; i++) {
            fileArr[i] = new File(externalFilesDirectories[i], f1608m);
            ensureDirectoryExists(fileArr[i]);
        }
        return fileArr;
    }

    public File getCloudBookDirectory() {
        File file = this.f1615A;
        if (file != null) {
            return file;
        }
        file = new File(this.f1634z, f1606k);
        ensureDirectoryExists(file);
        this.f1615A = file;
        return file;
    }

    public File getMiCloudBookDirectory() {
        File file = this.f1616B;
        if (file != null) {
            return file;
        }
        file = new File(this.f1634z, f1611p);
        ensureDirectoryExists(file);
        this.f1616B = file;
        return file;
    }

    public File getDownloadedCoverDirectory() {
        File file = this.f1617C;
        if (file != null) {
            return file;
        }
        file = new File(this.f1634z, f1609n);
        ensureDirectoryExists(file);
        this.f1617C = file;
        return file;
    }

    public boolean isMiCloudBookPath(String str) {
        return str.contains(new StringBuilder().append(File.separator).append(this.f1628t).append(f1611p).toString()) || str.contains(File.separator + this.f1628t + f1610o);
    }

    public File getPluginsDirectory() {
        File file = new File(this.f1632x, f1613r);
        ensureDirectoryExists(file);
        return file;
    }

    public File getUserFontDirectory() {
        File file = new File(this.f1632x, f1612q);
        ensureDirectoryExists(file);
        return file;
    }

    public File getSystemFontFileZh() {
        return (File) this.f1621G.m707a();
    }

    public File getSystemFontFileEn() {
        return (File) this.f1622H.m707a();
    }

    public final File getExternalFilesDirectory() {
        return this.f1632x;
    }

    public final synchronized File getSecondaryFilesDirectory() {
        return this.f1634z;
    }

    public synchronized File[] getExternalFilesDirectories() {
        return this.f1632x.equals(this.f1634z) ? new File[]{this.f1632x} : new File[]{this.f1632x, this.f1634z};
    }

    public final synchronized void setSecondaryStorageDirectory(File file) {
        if (file != null) {
            setPrefString(PrivatePref.PERSONAL, "storage", file.getAbsolutePath());
            commitPrefs();
            this.f1634z = secondaryFilesDir(this.f1632x);
            ensureDirectoryExists(this.f1634z);
            this.f1615A = null;
            this.f1616B = null;
            this.f1617C = null;
        }
    }

    public int getVersionCode() {
        int i = 0;
        try {
            return this.f1627b.getPackageManager().getPackageInfo(this.f1627b.getPackageName(), 0).versionCode;
        } catch (Throwable th) {
            return i;
        }
    }

    public synchronized int getFirstVersionCode() {
        return this.f1629u.getInt("global__first_version_code", 0);
    }

    public synchronized int getLastVersionCode() {
        return this.f1629u.getInt("global__last_version_code", 0);
    }

    public synchronized String getVersionName() {
        String str;
        try {
            str = this.f1627b.getPackageManager().getPackageInfo(this.f1627b.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            str = "1.7.0";
        }
        return str;
    }

    public synchronized String getDistChannel() {
        return this.f1629u.getString("global__dist_channel", "");
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
        return this.f1629u.getBoolean("global__app_store_guide", false);
    }

    public synchronized void setShowAppStoreGuide(boolean z) {
        getPrefsEditor().putBoolean("global__app_store_guide", z);
        commitPrefs();
    }

    public synchronized int getLastUseDay() {
        return this.f1629u.getInt("global__last_use_day", 0);
    }

    public synchronized void setLastUseDay(int i) {
        getPrefsEditor().putInt("global__last_use_day", i);
        commitPrefs();
    }

    public synchronized int getUseDays() {
        return this.f1629u.getInt("global__use_days", 0);
    }

    public synchronized void setUseDays(int i) {
        getPrefsEditor().putInt("global__use_days", i);
        commitPrefs();
    }

    public synchronized long getAdvancedActionTime() {
        return this.f1629u.getLong("global__advanced_action_time", 0);
    }

    public synchronized void setAdvancedActionTime(long j) {
        getPrefsEditor().putLong("global__advanced_action_time", j);
        commitPrefs();
    }

    public boolean getShowPurchasedHint() {
        if (DkApp.get().activateFromLauncher()) {
            return this.f1629u.getBoolean("global__show_purchased_hint", true);
        }
        return false;
    }

    public void setShowPurchasedHint(boolean z) {
        getPrefsEditor().putBoolean("global__show_purchased_hint", z);
        commitPrefs();
    }

    public synchronized int getDefaultReadingFontSize() {
        return C0267i.m598a(this.f1627b, 18.0f);
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
        return this.f1629u.getBoolean("global__fresh_install", true);
    }

    public boolean needAddNewbieBook() {
        return this.f1629u.getBoolean("global__need_add_newbie_book", false);
    }

    public void setNeedAddNewbieBook(boolean z) {
        getPrefsEditor().putBoolean("global__need_add_newbie_book", z);
        commitPrefs();
    }

    public synchronized boolean isFirstCloudSync() {
        return this.f1629u.getBoolean("global__first_cloud_sync", true);
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
        return this.f1627b.getString(C0247i.app__shared__build_name);
    }

    public synchronized Class<?> loadExtendClass(String str) {
        return loadExtendClass(str, extendLibraryFile());
    }

    public synchronized Class<?> loadExtendCompatClass(String str) {
        return loadExtendClass(str, extendLibraryCompatFile());
    }

    private synchronized Class<?> loadExtendClass(String str, File file) {
        Class<?> loadClass;
        boolean z = true;
        synchronized (this) {
            String str2 = this.f1627b.getApplicationInfo().dataDir + "/lib" + File.pathSeparator + this.f1627b.getPackageCodePath() + "!/lib/armeabi";
            try {
                ClassLoader classLoader;
                boolean z2;
                if (this.f1620F.containsKey(file)) {
                    classLoader = (ClassLoader) this.f1620F.get(file);
                } else if (VERSION.SDK_INT >= 21) {
                    classLoader = new DexClassLoader(file.getAbsolutePath(), this.f1627b.getCodeCacheDir().getAbsolutePath(), str2, getClass().getClassLoader());
                } else {
                    classLoader = new DexClassLoader(file.getAbsolutePath(), this.f1627b.getCacheDir().getAbsolutePath(), str2, getClass().getClassLoader());
                }
                loadClass = classLoader.loadClass(str);
                WebLog c = WebLog.init();
                if (loadClass != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                c.w(z2);
                if (loadClass != null) {
                    if (!this.f1620F.containsKey(file)) {
                        this.f1620F.put(file, classLoader);
                    }
                }
            } catch (Throwable th) {
                WebLog.init().printStackTrace(LogLevel.ERROR, "env", String.format("fail to load extend class(class=%s, file=%s)", new Object[]{str, file}), th);
            }
            try {
                ClassLoader pathClassLoader = new PathClassLoader(file.getAbsolutePath(), str2, getClass().getClassLoader());
                loadClass = pathClassLoader.loadClass(str);
                WebLog c2 = WebLog.init();
                if (loadClass == null) {
                    z = false;
                }
                c2.w(z);
                if (loadClass != null) {
                    if (!this.f1620F.containsKey(file)) {
                        this.f1620F.put(file, pathClassLoader);
                    }
                }
            } catch (Throwable th2) {
                WebLog.init().printStackTrace(LogLevel.ERROR, "env", String.format("fail to load extend class(class=%s, file=%s)", new Object[]{str, file}), th2);
            }
            loadClass = null;
        }
        return loadClass;
    }

    public Drawable getOldPaperDrawable() {
        return (Drawable) this.f1623I.m707a();
    }

    public boolean onMiui() {
        return C0373z.m1052a();
    }

    public boolean isVipDevice() {
        return TextUtils.equals(Build.MANUFACTURER, "Xiaomi") && (TextUtils.equals("Mi Note 2", SystemProperties.get("ro.product.model")) || TextUtils.equals("MIX", SystemProperties.get("ro.product.model")));
    }

    public boolean isNotchDevice() {
        return SystemProperties.getInt("ro.miui.notch", 0) == 1;
    }

    public boolean onHongMi() {
        if (this.f1630v.m861b()) {
            return ((Boolean) this.f1630v.m858a()).booleanValue();
        }
        try {
            Class cls = Class.forName("miui.os.Build");
            if (cls != null) {
                this.f1630v.mo975a(Boolean.valueOf(cls.getDeclaredField("IS_HONGMI").getBoolean(null)));
                return ((Boolean) this.f1630v.m858a()).booleanValue();
            }
            this.f1630v.mo975a(Boolean.valueOf(false));
            return false;
        } catch (Throwable th) {
            if (Build.MANUFACTURER.contains("Xiaomi") && Build.DEVICE.startsWith("HM")) {
                this.f1630v.mo975a(Boolean.valueOf(true));
                return true;
            }
            this.f1630v.mo975a(Boolean.valueOf(false));
            return false;
        }
    }

    public synchronized String getPrefString(PrivatePref privatePref, String str, String str2) {
        return this.f1629u.getString(getPrefKey(privatePref, str), str2);
    }

    public synchronized void setPrefString(PrivatePref privatePref, String str, String str2) {
        getPrefsEditor().putString(getPrefKey(privatePref, str), str2);
    }

    public synchronized long getPrefLong(PrivatePref privatePref, String str, long j) {
        return this.f1629u.getLong(getPrefKey(privatePref, str), j);
    }

    public synchronized void setPrefLong(PrivatePref privatePref, String str, long j) {
        getPrefsEditor().putLong(getPrefKey(privatePref, str), j);
    }

    public synchronized int getPrefInt(PrivatePref privatePref, String str, int i) {
        return this.f1629u.getInt(getPrefKey(privatePref, str), i);
    }

    public synchronized void setPrefInt(PrivatePref privatePref, String str, int i) {
        getPrefsEditor().putInt(getPrefKey(privatePref, str), i);
    }

    public synchronized float getPrefFloat(PrivatePref privatePref, String str, float f) {
        return this.f1629u.getFloat(getPrefKey(privatePref, str), f);
    }

    public synchronized void setPrefFloat(PrivatePref privatePref, String str, float f) {
        getPrefsEditor().putFloat(getPrefKey(privatePref, str), f);
    }

    public synchronized boolean getPrefBoolean(PrivatePref privatePref, String str, boolean z) {
        return this.f1629u.getBoolean(getPrefKey(privatePref, str), z);
    }

    public synchronized void setPrefBoolean(PrivatePref privatePref, String str, boolean z) {
        getPrefsEditor().putBoolean(getPrefKey(privatePref, str), z);
    }

    public synchronized void removePrefKey(PrivatePref privatePref, String str) {
        getPrefsEditor().remove(getPrefKey(privatePref, str));
    }

    public synchronized boolean hasPrefKey(PrivatePref privatePref, String str) {
        return this.f1629u.contains(getPrefKey(privatePref, str));
    }

    public synchronized void commitPrefs() {
        if (this.f1618D != null) {
            this.f1618D.apply();
            this.f1618D = null;
        }
    }

    public static synchronized void startup(DkApp dkApp) {
        synchronized (ReaderEnv.class) {
            if (f1597a == null) {
                f1597a = new ReaderEnv(dkApp);
            }
        }
    }

    public static synchronized ReaderEnv get() {
        ReaderEnv readerEnv;
        synchronized (ReaderEnv.class) {
            if (f1598c || f1597a != null) {
                readerEnv = f1597a;
            } else {
                throw new AssertionError();
            }
        }
        return readerEnv;
    }

    public final boolean forHd() {
        return this.f1627b.forHd();
    }

    public final String getAppName() {
        return this.f1628t;
    }

    public String getAppId() {
        return this.f1627b.getAppId();
    }

    public String getAppIdforStore() {
        return this.f1627b.getAppIdforStore();
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
        return this.f1629u.getBoolean("global__sync_enabled", true);
    }

    public synchronized void setSyncEnabled(boolean z) {
        getPrefsEditor().putBoolean("global__sync_enabled", z);
        commitPrefs();
    }

    public synchronized boolean getSyncBookshelfEnabled() {
        return this.f1629u.getBoolean("global__sync_enabled", true);
    }

    public synchronized boolean getSyncEvernoteEnabled() {
        return this.f1629u.getBoolean("global__sync_evernote", false);
    }

    public synchronized void setSyncEvernoteEnabled(boolean z) {
        getPrefsEditor().putBoolean("global__sync_evernote", z);
        commitPrefs();
    }

    public synchronized boolean getIsOnlyWifiSyncEvernote() {
        return this.f1629u.getBoolean("global__only_wifi_sync_evernote", true);
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
        return this.f1629u.getBoolean("global__receive_reply", true);
    }

    public void addOnReaderPrefChangedListener(PrivatePref privatePref, OnReaderPrefChangedListener onReaderPrefChangedListener) {
        if (!this.f1624J.contains(privatePref)) {
            this.f1624J.putIfAbsent(privatePref, new CopyOnWriteArrayList());
        }
        ((CopyOnWriteArrayList) this.f1624J.get(privatePref)).addIfAbsent(onReaderPrefChangedListener);
    }

    public synchronized void setUpdatePushStatus(boolean z) {
        getPrefsEditor().putBoolean("global__update_push_status", z);
        commitPrefs();
    }

    public synchronized boolean getUpdatePushStatus() {
        return this.f1629u.getBoolean("global__update_push_status", false);
    }

    public synchronized boolean getReceivePushes() {
        return this.f1629u.getBoolean("global__receive_pushes", true);
    }

    public synchronized void setReceivePushes(boolean z) {
        getPrefsEditor().putBoolean("global__receive_pushes", z);
        commitPrefs();
    }

    public synchronized int getNewVersion() {
        return this.f1629u.getInt("global__new_version_code", getVersionCode());
    }

    public synchronized void setNewVersion(int i) {
        getPrefsEditor().putInt("global__new_version_code", i);
        commitPrefs();
    }

    public synchronized long getLastDetectUpdateTime() {
        return this.f1629u.getLong("global__last_detect_update_time", -1);
    }

    public synchronized void setLastDetectUpdateTime(long j) {
        getPrefsEditor().putLong("global__last_detect_update_time", j);
        commitPrefs();
    }

    public synchronized boolean getKeepReading() {
        return this.f1629u.getBoolean("global__keep_reading", false);
    }

    public synchronized void setKeepReading(boolean z) {
        getPrefsEditor().putBoolean("global__keep_reading", z);
        commitPrefs();
    }

    public synchronized String getReadingBookUuid() {
        return this.f1629u.getString("global__reading_book_uuid", "");
    }

    public synchronized void setReadingBookUuid(String str) {
        getPrefsEditor().putString("global__reading_book_uuid", str);
        commitPrefs();
    }

    public synchronized long getLastShowStoreDay() {
        return this.f1629u.getLong("global__last_show_store_day", 0);
    }

    public synchronized long updateLastShowStoreDay() {
        long currentTimeMillis;
        currentTimeMillis = (System.currentTimeMillis() + ((long) TimeZone.getDefault().getRawOffset())) / 86400000;
        getPrefsEditor().putLong("global__last_show_store_day", currentTimeMillis);
        commitPrefs();
        return currentTimeMillis;
    }

    public synchronized long getLastCommentTime() {
        return this.f1629u.getLong("global__last_comment_time", 0);
    }

    public synchronized void setLastCommentTime(long j) {
        getPrefsEditor().putLong("global__last_comment_time", j);
        commitPrefs();
    }

    public synchronized Set<String> getMarketCDNIpOnWifi() {
        return this.f1629u.getStringSet("global__market_cdn_ip_on_wifi", new HashSet());
    }

    public synchronized void setMarketCDNIpOnWifi(Set<String> set) {
        getPrefsEditor().putStringSet("global__market_cdn_ip_on_wifi", set);
        commitPrefs();
    }

    public synchronized Set<String> getMarketCDNIpOnWap() {
        return this.f1629u.getStringSet("global__market_cdn_ip_on_wap", new HashSet());
    }

    public synchronized void setMarketCDNIpOnWap(Set<String> set) {
        getPrefsEditor().putStringSet("global__market_cdn_ip_on_wap", set);
        commitPrefs();
    }

    public synchronized long getLastGetCDNIpTime() {
        return this.f1629u.getLong("global__last_get_cdn_ip_date", 0);
    }

    public synchronized void setLastGetCDNIpTime(long j) {
        getPrefsEditor().putLong("global__last_get_cdn_ip_date", j);
        commitPrefs();
    }

    public synchronized BookshelfItemStyle getBookshelfItemStyle() {
        BookshelfItemStyle bookshelfItemStyle;
        bookshelfItemStyle = BookshelfItemStyle.SIMPLE;
        try {
            bookshelfItemStyle = BookshelfItemStyle.valueOf(this.f1629u.getString("global__bookshelf_item_style", BookshelfItemStyle.SIMPLE.name()));
        } catch (Throwable th) {
        }
        return bookshelfItemStyle;
    }

    public synchronized void setBookshelfItemStyle(BookshelfItemStyle bookshelfItemStyle) {
        if (getBookshelfItemStyle() != bookshelfItemStyle) {
            getPrefsEditor().putString("global__bookshelf_item_style", bookshelfItemStyle.name());
            commitPrefs();
            if (this.f1626L != null) {
                this.f1626L.onBookshelfItemStyleChanged(bookshelfItemStyle);
            }
        }
    }

    public synchronized void setOnBookshelfItemStyleChangedListener(OnBookshelfItemStyleChangedListener onBookshelfItemStyleChangedListener) {
        this.f1626L = onBookshelfItemStyleChangedListener;
    }

    public synchronized boolean getIsWifiAutoDownloadFontAble() {
        return this.f1629u.getBoolean("global__wifi_auto_download_font", false);
    }

    public synchronized void setIsWifiAutoDownloadFontAble(boolean z) {
        getPrefsEditor().putBoolean("global__wifi_auto_download_font", z);
        commitPrefs();
    }

    public synchronized long getLastShowLoginDialogInAnonymousTime() {
        return this.f1629u.getLong("global__show_login_dialog_in_anoymous_account", 0);
    }

    public synchronized void setLastShowLoginDialogInAnonymousTime(long j) {
        getPrefsEditor().putLong("global__show_login_dialog_in_anoymous_account", j);
        commitPrefs();
    }

    public synchronized int getBookOpenTimes() {
        return this.f1629u.getInt("global__opened_books", 0);
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
        return this.f1629u.getBoolean("iciba_enable_network", true);
    }

    public synchronized long getUpdateDownloadTaskId() {
        return this.f1629u.getLong("global__update_download_task_id", -1);
    }

    public synchronized void setUpdateDownloadTaskId(long j) {
        getPrefsEditor().putLong("global__update_download_task_id", j);
        commitPrefs();
    }

    public synchronized C0272a getDb() {
        return this.f1619E;
    }

    public synchronized void addOnBookShelfTypeChangedListener(OnBookShelfTypeChangedListener onBookShelfTypeChangedListener) {
        this.f1625K.add(onBookShelfTypeChangedListener);
    }

    public synchronized void removeOnBookShelfTypeChangedListener(OnBookShelfTypeChangedListener onBookShelfTypeChangedListener) {
        this.f1625K.remove(onBookShelfTypeChangedListener);
    }

    public synchronized BookShelfType getBookShelfType() {
        BookShelfType valueOf;
        try {
            valueOf = BookShelfType.valueOf(this.f1629u.getString("global__bookshelf_type", ""));
        } catch (Exception e) {
            valueOf = BookShelfType.Simple;
        }
        return valueOf;
    }

    public synchronized void setBookShelfType(BookShelfType bookShelfType) {
        getPrefsEditor().putString("global__bookshelf_type", bookShelfType.toString());
        commitPrefs();
        Iterator it = this.f1625K.iterator();
        while (it.hasNext()) {
            ((OnBookShelfTypeChangedListener) it.next()).onBookShelfTypeChanged(bookShelfType);
        }
    }

    public synchronized int getShoppingCartSituation() {
        return this.f1629u.getInt("global__shopping_cart_situation", 2);
    }

    public synchronized void setShoppingCartSituation(int i) {
        getPrefsEditor().putInt("global__shopping_cart_situation", i);
        commitPrefs();
    }

    public int getUserGender() {
        return this.f1629u.getInt("global__user_gender", -1);
    }

    public synchronized boolean getIsSendNow() {
        return this.f1629u.getBoolean("global__send_now", true);
    }

    public synchronized void setIsSendNow(boolean z) {
        getPrefsEditor().putBoolean("global__send_now", z);
        commitPrefs();
    }

    public synchronized String getMiLiveUser() {
        return this.f1629u.getString("global__mi_live_user", "");
    }

    public synchronized void setMiLiveUser(String str) {
        getPrefsEditor().putString("global__mi_live_user", str);
        commitPrefs();
    }

    public void onRunningStateChanged(ManagedApp managedApp, RunningState runningState, RunningState runningState2) {
        if (runningState2 == RunningState.BACKGROUND) {
            commitPrefs();
        }
    }

    private String getNewDeviceId() {
        String[] genDeviceIds = genDeviceIds(new String[]{getMacAddress(), getAndroidId()});
        if (f1598c || genDeviceIds.length > 0) {
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
            obj = ((TelephonyManager) this.f1627b.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(obj)) {
            try {
                obj = ((WifiManager) this.f1627b.getSystemService("wifi")).getConnectionInfo().getMacAddress();
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
                obj = Secure.getString(this.f1627b.getContentResolver(), "android_id");
            } catch (Exception e222) {
                e222.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(obj)) {
            return "";
        }
        return this.f1627b.getDeviceIdPrefix() + obj;
    }

    private void prepareInternalFiles() {
        if (!this.f1633y.exists()) {
            WebLog.init().a(LogLevel.EVENT, "env", "preparing internal files...(ver=%d)", Integer.valueOf(17));
            int i = 0;
            while (i < 3) {
                File file = new File(this.f1631w, "res.v17.arch");
                FileUtil.deleteFile(file);
                File file2 = new File(this.f1633y.getAbsolutePath() + ".tmp");
                FileUtil.deleteFile(file2);
                file2.mkdirs();
                OutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    DkPublic.extractRawResource(this.f1627b, fileOutputStream, C0246h.raw__shared__res_files);
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (Throwable th) {
                    }
                    DkarchLib.extract(file.getAbsolutePath(), file2.getAbsolutePath());
                    FileUtil.deleteFile(this.f1633y);
                    if (file2.renameTo(this.f1633y)) {
                        WebLog.init().a(LogLevel.EVENT, "env", "internal files are ready(ver=%d)", Integer.valueOf(17));
                        FileUtil.deleteFile(file);
                        FileUtil.deleteFile(file2);
                        return;
                    }
                    WebLog.init().a(LogLevel.ERROR, "env", "can't move internal files in place(ver=%d)", Integer.valueOf(17));
                    FileUtil.deleteFile(file);
                    FileUtil.deleteFile(file2);
                    UIdleHandler.sleep(3000);
                    i++;
                } catch (Throwable th2) {
                    try {
                        WebLog.init().printStackTrace(LogLevel.ERROR, "env", String.format("an exception occurs while preparing internal files(ver=%d)", new Object[]{Integer.valueOf(17)}), th2);
                    } finally {
                        FileUtil.deleteFile(file);
                        FileUtil.deleteFile(file2);
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
        return this.f1629u.getString("global__cached_device_id", "");
    }

    protected void setCachedDeviceId(String str) {
        getPrefsEditor().putString("global__cached_device_id", str);
    }

    private Editor getPrefsEditor() {
        if (this.f1618D == null) {
            this.f1618D = this.f1629u.edit();
        }
        return this.f1618D;
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
        if (f1598c) {
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
                strArr2[i] = String.format(this.f1627b.getDeviceIdPrefix() + "%d00%s", new Object[]{Integer.valueOf(i + 1), C0366o.m1030a(strArr[i], "utf-16", "md5")});
            }
        }
        return strArr2;
    }

    private String getMacAddress() {
        String str = "";
        try {
            return ((WifiManager) this.f1627b.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    private String getAndroidId() {
        String str = "";
        try {
            str = Secure.getString(this.f1627b.getContentResolver(), "android_id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    private File extendLibraryFile() {
        return new File(this.f1633y, f1599d + File.separator + "ext_lib.apk");
    }

    private File extendLibraryCompatFile() {
        return new File(this.f1633y, f1599d + File.separator + "ext_lib_comp.apk");
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
        List<File> a = FileUtil.getDirFiles(new File("/system/fonts"), new FileFilter[0]);
        Collections.sort(a, new C04824(this));
        for (File file4 : a) {
            if (DkUtils.isZhFont(file4.getAbsolutePath())) {
                return file4;
            }
        }
        WebLog.init().defaultW();
        return new File("/system/fonts", "DroidSansFallback.ttf");
    }

    private File secondaryFilesDir(File file) {
        Object prefString = getPrefString(PrivatePref.PERSONAL, "storage", "");
        if (TextUtils.isEmpty(prefString)) {
            return file;
        }
        File file2 = new File(prefString);
        return (file2.canRead() && file2.canWrite() && file2.getFreeSpace() > 0) ? new File(file2, this.f1628t) : file;
    }

    private static void configHttps() {
        try {
            TrustManager[] trustManagerArr = new TrustManager[]{new C04835()};
            SSLContext instance = SSLContext.getInstance("SSL");
            instance.init(null, trustManagerArr, new SecureRandom());
            HostnameVerifier c04846 = new C04846();
            HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(c04846);
        } catch (Throwable th) {
        }
    }
}
