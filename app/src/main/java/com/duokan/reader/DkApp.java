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
import com.duokan.core.diagnostic.C0327f;
import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.io.C0336a;
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
import org.apache.http.HttpHost;

public abstract class DkApp extends ManagedApp {
    /* renamed from: b */
    private static final Locale f1373b = Locale.getDefault();
    /* renamed from: c */
    private final File f1374c = new File(Environment.getExternalStorageDirectory(), getAppName() + "/Diagnostic");
    /* renamed from: d */
    private final ConcurrentLinkedQueue<Runnable> f1375d = new ConcurrentLinkedQueue();
    /* renamed from: e */
    private final LinkedList<Runnable> f1376e = new LinkedList();
    /* renamed from: f */
    private final LinkedList<Runnable> f1377f = new LinkedList();
    /* renamed from: g */
    private boolean f1378g = false;
    /* renamed from: h */
    private boolean f1379h = false;
    /* renamed from: i */
    private SharedPreferences f1380i = null;
    /* renamed from: j */
    private boolean f1381j = true;
    /* renamed from: k */
    private boolean f1382k = false;
    /* renamed from: l */
    private boolean f1383l = true;

    /* renamed from: com.duokan.reader.DkApp$3 */
    class C04133 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ DkApp f1366a;

        C04133(DkApp dkApp) {
            this.f1366a = dkApp;
        }

        public void run() {
            if (!this.f1366a.f1379h) {
                this.f1366a.f1379h = true;
                while (!this.f1366a.f1377f.isEmpty()) {
                    ((Runnable) this.f1366a.f1377f.poll()).run();
                }
            }
        }
    }

    /* renamed from: com.duokan.reader.DkApp$4 */
    class C04144 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ DkApp f1367a;

        C04144(DkApp dkApp) {
            this.f1367a = dkApp;
        }

        public void run() {
            C0554a.m2459b().m2463a(true);
            UmengManager.get().setEnabled(true);
        }
    }

    /* renamed from: com.duokan.reader.DkApp$5 */
    class C04175 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ DkApp f1371a;

        /* renamed from: com.duokan.reader.DkApp$5$1 */
        class C04151 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C04175 f1368a;

            C04151(C04175 c04175) {
                this.f1368a = c04175;
            }

            public void run() {
                this.f1368a.f1371a.runPreReadyTasks();
                this.f1368a.f1371a.f1378g = true;
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
                for (File f : C0336a.m776a(this.f1371a.getDiagnosticDirectory(), new FileFilter(this) {
                    /* renamed from: b */
                    final /* synthetic */ C04175 f1370b;

                    public boolean accept(File file) {
                        return file.lastModified() < currentTimeMillis;
                    }
                })) {
                    C0336a.m793f(f);
                }
            } catch (Throwable th) {
                C0328a.m757c().m748a(LogLevel.ERROR, "app", "an exception occurs during background init", th);
            }
        }
    }

    /* renamed from: com.duokan.reader.DkApp$6 */
    class C04186 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ DkApp f1372a;

        C04186(DkApp dkApp) {
            this.f1372a = dkApp;
        }

        public void run() {
            Iterator it = this.f1372a.f1376e.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            this.f1372a.f1376e.clear();
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
        C0328a.m757c().m750a(getLogFile("debug"));
        C0328a.m757c().m765c(true);
        C0328a.m757c().m759a("app_load_timer");
    }

    public File getDiagnosticDirectory() {
        return this.f1374c;
    }

    public File getLogFile(String str) {
        String format = new SimpleDateFormat("yyyyMMddkkmm", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
        return new File(getDiagnosticDirectory(), String.format(Locale.US, "%s.%s.%d.log", new Object[]{str, format, Integer.valueOf(Process.myPid())}));
    }

    public Locale getSystemLocale() {
        return f1373b;
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
        return this.f1380i.getLong("first_active_time", 0);
    }

    public long getUserFirstActiveTime() {
        return this.f1380i.getLong("user_first_active_time", 0);
    }

    public long getUserLastActiveTime() {
        return this.f1380i.getLong("user_last_active_time", 0);
    }

    public boolean isReady() {
        return this.f1378g;
    }

    public boolean activateFromLauncher() {
        return this.f1383l;
    }

    public void setIsActivateFromLauncher(boolean z) {
        this.f1383l = z;
    }

    public boolean isUiReady() {
        return this.f1379h;
    }

    public void runPreReady(Runnable runnable) {
        this.f1375d.add(runnable);
    }

    public void runWhenAppReady(final Runnable runnable) {
        if (runnable != null) {
            UThread.post(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ DkApp f1363b;

                public void run() {
                    if (this.f1363b.f1378g) {
                        runnable.run();
                    } else {
                        this.f1363b.f1376e.add(runnable);
                    }
                }
            });
        }
    }

    public void runWhenUiReady(final Runnable runnable) {
        if (runnable != null) {
            UThread.post(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ DkApp f1365b;

                public void run() {
                    if (this.f1365b.f1379h) {
                        runnable.run();
                    } else {
                        this.f1365b.f1377f.add(runnable);
                    }
                }
            });
        }
    }

    public void setReadyToSee() {
        runWhenAppReady(new C04133(this));
    }

    public Locale getUserChosenLocale() {
        Object string = this.f1380i.getString("user_chosen_locale_language", "");
        String string2 = this.f1380i.getString("user_chosen_locale_country", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new Locale(string, string2);
    }

    public void setUserChosenLocale(Locale locale) {
        String str;
        String str2;
        Editor edit = this.f1380i.edit();
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
        return this.f1381j;
    }

    public boolean isWebAccessConfirmed() {
        return this.f1380i.getBoolean("web_access_confirmed", false);
    }

    public boolean isCameraPermissionConfirmed() {
        return this.f1380i.getBoolean("camera_confirmed", false);
    }

    public void setCameraPermissionConfirmed() {
        Editor edit = this.f1380i.edit();
        edit.putBoolean("camera_confirmed", true);
        edit.apply();
    }

    public boolean isSmsPermissionConfirmed() {
        return this.f1380i.getBoolean("sms_confirmed", false);
    }

    public void setSmsPermissionConfirmed() {
        Editor edit = this.f1380i.edit();
        edit.putBoolean("sms_confirmed", true);
        edit.apply();
    }

    public void setWebAccessConfirmed(boolean z) {
        Editor edit = this.f1380i.edit();
        edit.putBoolean("web_access_confirmed", z);
        edit.apply();
        if (z) {
            this.f1381j = true;
            runWhenAppReady(new C04144(this));
        }
    }

    public boolean inCtaMode() {
        if (!forHd() && TextUtils.equals(DkPublic.getChannelName(this), "Xiaomi")) {
            return true;
        }
        return false;
    }

    public boolean getAutoLogin() {
        return this.f1380i.getBoolean("auto_login", true);
    }

    public void setAutoLogin(boolean z) {
        Editor edit = this.f1380i.edit();
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
        this.f1380i = getSharedPreferences("config", 0);
        this.f1381j = inCtaMode() ? isWebAccessConfirmed() : true;
        try {
            HttpResponseCache.install(new File(getCacheDir(), HttpHost.DEFAULT_SCHEME_NAME), 10485760);
        } catch (IOException e) {
        }
        ReaderEnv.startup(this);
        C0328a.m757c().m752c(LogLevel.INFO, "app", "duokan version code: " + ReaderEnv.get().getVersionCode());
        C0559f.m2470a((Context) this);
        C0554a.m2457a((Context) this);
        C0554a.m2459b().m2463a(isWebAccessEnabled());
        C0641o.m2932a(ReaderEnv.get(), C0559f.m2476b());
        if (isDebuggable() || (forCommunity() && C0641o.m2934i().m2985l())) {
            C0327f c0327f = new C0327f();
            c0327f.m750a(getLogFile(HttpHost.DEFAULT_SCHEME_NAME));
            WebSession.setLogger(c0327f);
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
            C0328a.m757c().m759a("app_bginit_timer");
            ah.m871b(new C04175(this));
        }
    }

    protected void onRunningStateChanged(RunningState runningState, RunningState runningState2) {
        super.onRunningStateChanged(runningState, runningState2);
        if (runningState2 == RunningState.FOREGROUND) {
            if (isWebAccessEnabled()) {
                C1163a.m8627k().m8650b();
            }
            Editor edit = this.f1380i.edit();
            long currentTimeMillis = System.currentTimeMillis();
            if (getUserFirstActiveTime() == 0) {
                edit.putLong("user_first_active_time", currentTimeMillis);
            }
            edit.putLong("user_last_active_time", currentTimeMillis);
            edit.apply();
            C0328a.m757c().m766d(true);
            return;
        }
        if (runningState == RunningState.FOREGROUND) {
            C1163a.m8627k().m8653c();
        }
        C0328a.m757c().m766d(false);
    }

    public void registerFirstActive() {
        if (getFirstActiveTime() == 0 && !Build.MODEL.equalsIgnoreCase("lithium")) {
            this.f1380i.edit().putLong("first_active_time", System.currentTimeMillis()).apply();
            Calendar instance = Calendar.getInstance(TimeZone.getDefault());
            instance.add(11, 24);
            instance.set(11, 18);
            C1039b.m7967a().m7985a("wake_up_user", WakeUpUserJob.class, instance.getTimeInMillis(), null);
        }
    }

    private void runPreReadyTasks() {
        Iterator it = this.f1375d.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f1375d.clear();
    }

    private void runOnReadyTasks() {
        UThread.post(new C04186(this));
    }
}
