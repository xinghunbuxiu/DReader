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

import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.IFeature;
import com.duokan.core.diagnostic.HttpLogger;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.a;
import com.duokan.core.sys.TaskHandler;
import com.duokan.core.sys.ah;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.push.z;

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
    private static final Locale b = Locale.getDefault();
    private final File c = new File(Environment.getExternalStorageDirectory(), getAppName() + "/Diagnostic");
    private final ConcurrentLinkedQueue d = new ConcurrentLinkedQueue();
    private final LinkedList e = new LinkedList();
    private final LinkedList f = new LinkedList();
    private boolean g = false;
    private boolean h = false;
    private SharedPreferences i = null;
    private boolean j = true;
    private boolean k = false;
    private boolean l = true;

    public abstract String getComicChapterEndAdUpId();

    public abstract String getFictionChapterEndAdUpId();

    public abstract Class getMainActivityClass();

    public abstract Class getReaderActivityClass();

    public abstract String getSplashAdUpId();

    protected abstract void onBackgroundInit();

    public abstract int supportAdSdkVersion();

    public abstract boolean supportFreeFictionTab();

    public abstract boolean supportWxPay();

    public DkApp() {
        a.c().a(getLogFile("debug"));
        a.c().c(true);
        a.c().a("app_load_timer");
    }

    public File getDiagnosticDirectory() {
        return this.c;
    }

    public File getLogFile(String str) {
        String format = new SimpleDateFormat("yyyyMMddkkmm", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
        return new File(getDiagnosticDirectory(), String.format(Locale.US, "%s.%s.%getScaledTouchSlop.log", new Object[]{str, format, Integer.valueOf(Process.myPid())}));
    }

    public Locale getSystemLocale() {
        return b;
    }

    public float hdScaleRate() {
        return 1.0f;
    }

    public IFeature webContext(IFeature featrue) {
        return featrue;
    }

    public Context noDensityScaleContext(Context context) {
        return context;
    }

    public boolean forCommunity() {
        return TextUtils.equals(DkPublic.getChannelName(this), "Community");
    }

    public long getFirstActiveTime() {
        return this.i.getLong("first_active_time", 0);
    }

    public long getUserFirstActiveTime() {
        return this.i.getLong("user_first_active_time", 0);
    }

    public long getUserLastActiveTime() {
        return this.i.getLong("user_last_active_time", 0);
    }

    public boolean isReady() {
        return this.g;
    }

    public boolean activateFromLauncher() {
        return this.l;
    }

    public void setIsActivateFromLauncher(boolean z) {
        this.l = z;
    }

    public boolean isUiReady() {
        return this.h;
    }

    public void runPreReady(Runnable runnable) {
        this.d.add(runnable);
    }

    public void runWhenAppReady(final Runnable runnable) {
        if (runnable != null) {
            TaskHandler.PostTask(new Runnable(this) {
                /* synthetic */
                DkApp b;

                public void run() {
                    if (this.b.g) {
                        runnable.run();
                    } else {
                        this.b.e.add(runnable);
                    }
                }
            });
        }
    }

    public void runWhenUiReady(final Runnable runnable) {
        if (runnable != null) {
            TaskHandler.PostTask(new Runnable(this) {
                final /* synthetic */ DkApp b;

                public void run() {
                    if (this.b.h) {
                        runnable.run();
                    } else {
                        this.b.f.add(runnable);
                    }
                }
            });
        }
    }

    public void setReadyToSee() {
        runWhenAppReady(new Runnable(this) {
            final /* synthetic */ DkApp a;

            {
                this.a = r1;
            }

            public void run() {
                if (!this.a.h) {
                    this.a.h = true;
                    while (!this.a.f.isEmpty()) {
                        ((Runnable) this.a.f.poll()).run();
                    }
                }
            }
        });
    }

    public Locale getUserChosenLocale() {
        Object string = this.i.getString("user_chosen_locale_language", "");
        String string2 = this.i.getString("user_chosen_locale_country", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new Locale(string, string2);
    }

    public void setUserChosenLocale(Locale locale) {
        String str;
        String str2;
        Editor edit = this.i.edit();
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
        return this.j;
    }

    public boolean isWebAccessConfirmed() {
        return this.i.getBoolean("web_access_confirmed", false);
    }

    public void setWebAccessConfirmed(boolean z) {
        Editor edit = this.i.edit();
        edit.putBoolean("web_access_confirmed", z);
        edit.apply();
        if (z) {
            this.j = true;
            runWhenAppReady(new Runnable(this) {
                final /* synthetic */ DkApp a;

                {
                    this.a = r1;
                }

                public void run() {
                    com.duokan.reader.common.c.a.b().a(true);
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
        return this.i.getBoolean("auto_login", true);
    }

    public void setAutoLogin(boolean z) {
        Editor edit = this.i.edit();
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
        this.i = getSharedPreferences("config", 0);
        this.j = inCtaMode() ? isWebAccessConfirmed() : true;
        try {
            HttpResponseCache.install(new File(getCacheDir(), HttpHost.DEFAULT_SCHEME_NAME), 10485760);
        } catch (IOException e) {
        }
        ReaderEnv.startup(this);
        a.c().c(LogLevel.INFO, "app", "duokan version code: " + ReaderEnv.get().getVersionCode());
        f.a((Context) this);
        com.duokan.reader.common.c.a.a((Context) this);
        com.duokan.reader.common.c.a.b().a(isWebAccessEnabled());
        p.a(ReaderEnv.get(), f.b());
        if (isDebuggable() || (forCommunity() && p.i().l())) {
            HttpLogger fVar = new HttpLogger();
            fVar.a(getLogFile(HttpHost.DEFAULT_SCHEME_NAME));
            WebSession.setLogger(fVar);
        }
        UmengManager.startup(this, isWebAccessEnabled(), isDebuggable());
        com.duokan.reader.domain.statistics.a.a(ReaderEnv.get(), UmengManager.get(), f.b());
        if (isWebAccessEnabled()) {
            com.duokan.reader.domain.statistics.a.k().a("app", 1);
        }
        i.a((Context) this);
        PersonalPrefs.a(this, i.f(), f.b(), ReaderEnv.get());
        z.a((Context) this, isWebAccessEnabled(), getMiAppId(), getMiAppKey());
        com.duokan.reader.domain.cloud.push.t.a();
        b.a(ReaderEnv.get());
        registerFirstActive();
        com.duokan.reader.domain.statistics.a.k().d();
    }

    protected void onActivityCreated(Activity activity, Bundle bundle) {
        super.onActivityCreated(activity, bundle);
        if (!this.k) {
            this.k = true;
            a.c().a("app_bginit_timer");
            ah.b(new Runnable(this) {
                final /* synthetic */ DkApp a;

                {
                    this.a = r1;
                }

                public void run() {
                    try {
                        this.a.onBackgroundInit();
                        com.duokan.reader.domain.statistics.a.k().e();
                        TaskHandler.postTask(new Runnable(this) {
                            final /* synthetic */ AnonymousClass5 a;

                            {
                                this.a = r1;
                            }

                            public void run() {
                                this.a.a.runPreReadyTasks();
                                this.a.a.g = true;
                                this.a.a.runOnReadyTasks();
                            }
                        });
                        final long currentTimeMillis = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(30);
                        for (File d : com.duokan.core.io.a.a(this.a.getDiagnosticDirectory(), new FileFilter(this) {
                            final /* synthetic */ AnonymousClass5 b;

                            public boolean accept(File file) {
                                return file.lastModified() < currentTimeMillis;
                            }
                        })) {
                            com.duokan.core.io.a.d(d);
                        }
                    } catch (Throwable th) {
                        a.c().a(LogLevel.ERROR, "app", "an exception occurs during background init", th);
                    }
                }
            });
        }
    }

    protected void onRunningStateChanged(RunningState runningState, RunningState runningState2) {
        super.onRunningStateChanged(runningState, runningState2);
        if (runningState2 == RunningState.FOREGROUND) {
            if (isWebAccessEnabled()) {
                com.duokan.reader.domain.statistics.a.k().b();
            }
            Editor edit = this.i.edit();
            long currentTimeMillis = System.currentTimeMillis();
            if (getUserFirstActiveTime() == 0) {
                edit.putLong("user_first_active_time", currentTimeMillis);
            }
            edit.putLong("user_last_active_time", currentTimeMillis);
            edit.apply();
            a.c().d(true);
            return;
        }
        if (runningState == RunningState.FOREGROUND) {
            com.duokan.reader.domain.statistics.a.k().c();
        }
        a.c().d(false);
    }

    public void registerFirstActive() {
        if (getFirstActiveTime() == 0 && !Build.MODEL.equalsIgnoreCase("lithium")) {
            this.i.edit().putLong("first_active_time", System.currentTimeMillis()).apply();
            Calendar instance = Calendar.getInstance(TimeZone.getDefault());
            instance.add(11, 24);
            instance.set(11, 18);
            b.a().a("wake_up_user", WakeUpUserJob.class, instance.getTimeInMillis(), null);
        }
    }

    private void runPreReadyTasks() {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.d.clear();
    }

    private void runOnReadyTasks() {
        TaskHandler.PostTask(new Runnable(this) {
            final /* synthetic */ DkApp a;

            {
                this.a = r1;
            }

            public void run() {
                Iterator it = this.a.e.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
                this.a.e.clear();
            }
        });
    }
}
