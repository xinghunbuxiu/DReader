package com.duokan.reader;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.http.HttpResponseCache;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;

import com.duokan.core.app.IFeature;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.diagnostic.HttpLogger;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.io.FileUtil;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.ah;
import com.duokan.reader.common.p037c.C0554a;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.push.C0872q;
import com.duokan.reader.domain.cloud.push.C0880y;
import com.duokan.reader.domain.job.C1039b;
import com.duokan.reader.domain.statistics.C1163a;

import org.apache.http.HttpHost;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

public abstract class DkApp extends ManagedApp {

    private static final Locale locale = Locale.getDefault();

    private final File diagnostic = new File(Environment.getExternalStorageDirectory(), getAppName() + "/Diagnostic");

    private final ConcurrentLinkedQueue<Runnable> concurrentLinkedQueue = new ConcurrentLinkedQueue();

    private final LinkedList<Runnable> runnableLinkedList = new LinkedList();

    private final LinkedList<Runnable> runnableLinkedList1 = new LinkedList();

    private boolean isReady = false;

    private boolean isUiReady = false;

    private SharedPreferences preferences = null;

    private boolean isWebAccessEnabled = true;

    private boolean f1382k = false;

    private boolean isActivateFromLauncher = true;


    class C04175 implements Runnable {

        final DkApp f1371a;

        
        class C04151 implements Runnable {

            final C04175 f1368a;

            C04151(C04175 c04175) {
                this.f1368a = c04175;
            }

            public void run() {
                this.f1368a.f1371a.runPreReadyTasks();
                this.f1368a.f1371a.isReady = true;
                this.f1368a.f1371a.runOnReadyTasks();
            }
        }

        C04175(DkApp dkApp) {
            this.f1371a = dkApp;
        }

        public void run() {
            try {
                this.f1371a.onBackgroundInit();
                C1163a.m8627k().m8658e();
                UThread.runOnThread(new C04151(this));
                final long currentTimeMillis = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(30);
                for (File f : FileUtil.getDirFiles(this.f1371a.getDiagnosticDirectory(), new FileFilter(this) {

                    public boolean accept(File file) {
                        return file.lastModified() < currentTimeMillis;
                    }
                })) {
                    FileUtil.deleteFile(f);
                }
            } catch (Throwable th) {
                WebLog.init().printStackTrace(LogLevel.ERROR, "app", "an exception occurs during background init", th);
            }
        }
    }


    class C04186 implements Runnable {

        final DkApp f1372a;

        C04186(DkApp dkApp) {
            this.f1372a = dkApp;
        }

        public void run() {
            Iterator it = this.f1372a.runnableLinkedList.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            this.f1372a.runnableLinkedList.clear();
        }
    }

    public abstract String getComicChapterEndAdUpId();

    public abstract String getFictionChapterEndAdUpId();

    public abstract Class<? extends Activity> getMainActivityClass();

    public abstract Class<? extends Activity> getReaderActivityClass();

    public abstract String getSplashAdUpId();

    protected abstract void onBackgroundInit();

    public abstract int supportAdSdkVersion();

    public abstract boolean supportFreeFictionTab();

    public abstract boolean supportWxPay();

    public DkApp() {
        WebLog.init().setFile(getLogFile("debug"));
        WebLog.init().setDebug(true);
        WebLog.init().getAppBginitTimer("app_load_timer");
    }

    public File getDiagnosticDirectory() {
        return this.diagnostic;
    }

    public File getLogFile(String str) {
        String format = new SimpleDateFormat("yyyyMMddkkmm", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
        return new File(getDiagnosticDirectory(), String.format(Locale.US, "%s.%s.%d.log", new Object[]{str, format, Integer.valueOf(Process.myPid())}));
    }

    public Locale getSystemLocale() {
        return locale;
    }

    public float hdScaleRate() {
        return 1.0f;
    }

    public IFeature webContext(IFeature mFeature) {
        return mFeature;
    }

    public Context noDensityScaleContext(Context context) {
        return context;
    }

    public boolean forCommunity() {
        return TextUtils.equals(DkPublic.getChannelName(this), "Community");
    }

    public long getFirstActiveTime() {
        return this.preferences.getLong("first_active_time", 0);
    }

    public long getUserFirstActiveTime() {
        return this.preferences.getLong("user_first_active_time", 0);
    }

    public long getUserLastActiveTime() {
        return this.preferences.getLong("user_last_active_time", 0);
    }

    public boolean isReady() {
        return this.isReady;
    }

    public boolean activateFromLauncher() {
        return this.isActivateFromLauncher;
    }

    public void setIsActivateFromLauncher(boolean z) {
        this.isActivateFromLauncher = z;
    }

    public boolean isUiReady() {
        return this.isUiReady;
    }

    public void runPreReady(Runnable runnable) {
        this.concurrentLinkedQueue.add(runnable);
    }

    public void runWhenAppReady(final Runnable runnable) {
        if (runnable != null) {
            UThread.post(new Runnable() {

                public void run() {
                    if (isReady) {
                        runnable.run();
                    } else {
                        runnableLinkedList.add(runnable);
                    }
                }
            });
        }
    }

    public void runWhenUiReady(final Runnable runnable) {
        if (runnable != null) {
            UThread.post(new Runnable() {

                public void run() {
                    if (isUiReady) {
                        runnable.run();
                    } else {
                        runnableLinkedList1.add(runnable);
                    }
                }
            });
        }
    }

    public void setReadyToSee() {
        runWhenAppReady(new Runnable() {
            @Override
            public void run() {
                if (!isUiReady) {
                    isUiReady = true;
                    while (!runnableLinkedList1.isEmpty()) {
                        runnableLinkedList1.poll().run();
                    }
                }
            }
        });
    }

    public Locale getUserChosenLocale() {
        Object string = this.preferences.getString("user_chosen_locale_language", "");
        String string2 = this.preferences.getString("user_chosen_locale_country", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new Locale(string, string2);
    }

    public void setUserChosenLocale(Locale locale) {
        String str;
        String str2;
        Editor edit = this.preferences.edit();
        if (locale == null) {
            str = "";
            str2 = "";
        } else {
            str = locale.getLanguage();
            str2 = locale.getCountry();
        }
        edit.putString("user_chosen_locale_language", str);
        edit.putString("user_chosen_locale_country", str2);
        edit.apply();
    }

    public boolean isWebAccessEnabled() {
        return this.isWebAccessEnabled;
    }

    public boolean isWebAccessConfirmed() {
        return this.preferences.getBoolean("web_access_confirmed", false);
    }

    public boolean isCameraPermissionConfirmed() {
        return this.preferences.getBoolean("camera_confirmed", false);
    }

    public void setCameraPermissionConfirmed() {
        Editor edit = this.preferences.edit();
        edit.putBoolean("camera_confirmed", true);
        edit.apply();
    }

    public boolean isSmsPermissionConfirmed() {
        return this.preferences.getBoolean("sms_confirmed", false);
    }

    public void setSmsPermissionConfirmed() {
        Editor edit = this.preferences.edit();
        edit.putBoolean("sms_confirmed", true);
        edit.apply();
    }

    public void setWebAccessConfirmed(boolean isWebAccessEnabled) {
        Editor edit = this.preferences.edit();
        edit.putBoolean("web_access_confirmed", isWebAccessEnabled);
        edit.apply();
        if (isWebAccessEnabled) {
            this.isWebAccessEnabled = true;
            runWhenAppReady(new Runnable() {
                @Override
                public void run() {
                    C0554a.m2459b().m2463a(true);
                    UmengManager.get().setEnabled(true);
                }
            });
        }
    }

    public boolean inCtaMode() {
        if (!forHd() && TextUtils.equals(DkPublic.getChannelName(this), "Xiaomi")) {
            return true;
        }
        return false;
    }

    public boolean getAutoLogin() {
        return this.preferences.getBoolean("auto_login", true);
    }

    public void setAutoLogin(boolean z) {
        Editor edit = this.preferences.edit();
        edit.putBoolean("auto_login", z);
        edit.apply();
    }

    public static DkApp get() {
        return (DkApp) ManagedApp.get();
    }

    public boolean forHd() {
        return false;
    }

    public String getAppName() {
        return "DuoKan";
    }

    public String getAppId() {
        return "DkReader.Android";
    }

    public String getAppIdforStore() {
        return "android";
    }

    public String getDeviceIdPrefix() {
        return "D006";
    }

    public String getMiAppId() {
        return "1004465";
    }

    public String getMiAppKey() {
        return "910100461465";
    }

    public void onCreate() {
        super.onCreate();
        this.preferences = getSharedPreferences("config", 0);
        this.isWebAccessEnabled = inCtaMode() ? isWebAccessConfirmed() : true;
        try {
            HttpResponseCache.install(new File(getCacheDir(), HttpHost.DEFAULT_SCHEME_NAME), 10485760);
        } catch (IOException e) {
        }
        ReaderEnv.startup(this);
        WebLog.init().c(LogLevel.INFO, "app", "duokan version code: " + ReaderEnv.get().getVersionCode());
        C0559f.m2470a(this);
        C0554a.m2457a(this);
        C0554a.m2459b().m2463a(isWebAccessEnabled());
        C0641o.m2932a(ReaderEnv.get(), C0559f.m2476b());
        if (isDebuggable() || (forCommunity() && C0641o.m2934i().m2985l())) {
            HttpLogger httpLogger = new HttpLogger();
            httpLogger.setFile(getLogFile(HttpHost.DEFAULT_SCHEME_NAME));
            WebSession.setLogger(httpLogger);
        }
        UmengManager.startup(this, isWebAccessEnabled(), isDebuggable());
        C1163a.m8619a(ReaderEnv.get(), UmengManager.get(), C0559f.m2476b());
        C0709k.m3478a((Context) this);
        PersonalPrefs.m5177a(this, C0709k.m3476a(), C0559f.m2476b(), ReaderEnv.get());
        C0880y.m5743a((Context) this, isWebAccessEnabled(), getMiAppId(), getMiAppKey());
        C0872q.m5708a();
        C1039b.m7968a(ReaderEnv.get());
        registerFirstActive();
        C1163a.m8627k().m8656d();
    }

    protected void onActivityCreated(Activity activity, Bundle bundle) {
        super.onActivityCreated(activity, bundle);
        if (!this.f1382k) {
            this.f1382k = true;
            WebLog.init().getAppBginitTimer("app_bginit_timer");
            ah.m871b(new C04175(this));
        }
    }

    protected void onRunningStateChanged(RunningState runningState, RunningState runningState2) {
        super.onRunningStateChanged(runningState, runningState2);
        if (runningState2 == RunningState.FOREGROUND) {
            if (isWebAccessEnabled()) {
                C1163a.m8627k().m8650b();
            }
            Editor edit = this.preferences.edit();
            long currentTimeMillis = System.currentTimeMillis();
            if (getUserFirstActiveTime() == 0) {
                edit.putLong("user_first_active_time", currentTimeMillis);
            }
            edit.putLong("user_last_active_time", currentTimeMillis);
            edit.apply();
            WebLog.init().m766d(true);
            return;
        }
        if (runningState == RunningState.FOREGROUND) {
            C1163a.m8627k().m8653c();
        }
        WebLog.init().m766d(false);
    }

    public void registerFirstActive() {
        if (getFirstActiveTime() == 0 && !Build.MODEL.equalsIgnoreCase("lithium")) {
            this.preferences.edit().putLong("first_active_time", System.currentTimeMillis()).apply();
            Calendar instance = Calendar.getInstance(TimeZone.getDefault());
            instance.add(11, 24);
            instance.set(11, 18);
            C1039b.m7967a().m7985a("wake_up_user", WakeUpUserJob.class, instance.getTimeInMillis(), null);
        }
    }

    private void runPreReadyTasks() {
        Iterator it = this.concurrentLinkedQueue.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.concurrentLinkedQueue.clear();
    }

    private void runOnReadyTasks() {
        UThread.post(new C04186(this));
    }
}
