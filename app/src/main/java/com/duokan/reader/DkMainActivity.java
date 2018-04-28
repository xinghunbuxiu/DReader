package com.duokan.reader;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.duokan.core.app.C0286x;
import com.duokan.core.app.BaseActivity;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.reader.WelcomeDialog.StateListener;
import com.duokan.reader.domain.account.C0420b;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.MiAccount;
import com.duokan.reader.domain.account.cn;
import com.duokan.reader.domain.bookshelf.BookUploadService;
import com.duokan.reader.domain.downloadcenter.DownloadService;
import com.duokan.reader.ui.C1367p;
import com.duokan.reader.ui.surfing.C1514a;
import com.duokan.reader.ui.surfing.C1522i;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DkMainActivity extends BaseActivity {
    /* renamed from: b */
    private static WeakReference<DkMainActivity> f1394b = new WeakReference(null);
    /* renamed from: c */
    private static C0286x f1395c = null;
    /* renamed from: d */
    private static long f1396d = -1;
    /* renamed from: e */
    private DkReaderController f1397e = null;
    /* renamed from: f */
    private boolean f1398f = true;

    /* renamed from: com.duokan.reader.DkMainActivity$3 */
    class C04233 implements StateListener {
        /* renamed from: a */
        final /* synthetic */ DkMainActivity f1389a;

        C04233(DkMainActivity dkMainActivity) {
            this.f1389a = dkMainActivity;
        }

        public void onEnd(Uri uri) {
            if (uri != null) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(DkApp.get(), DkReader.get().getMainActivityClass()));
                intent.setAction("android.intent.action.VIEW");
                intent.setData(uri);
                this.f1389a.startActivity(intent);
            }
            WelcomeDialog.fetchNewSplash();
        }
    }

    /* renamed from: com.duokan.reader.DkMainActivity$5 */
    final class C04265 implements C0286x {
        C04265() {
        }

        public void onRunningStateChanged(ManagedApp managedApp, RunningState runningState, RunningState runningState2) {
            if (runningState2 == RunningState.FOREGROUND) {
                if (DkReader.get().isReady() && DkMainActivity.f1396d >= 0 && System.currentTimeMillis() - DkMainActivity.f1396d >= TimeUnit.MINUTES.toMillis(5)) {
                    Context topActivity = managedApp.getTopActivity();
                    if (topActivity != null) {
                        final ReaderFeature readerFeature = (ReaderFeature) managedApp.getContext().queryFeature(ReaderFeature.class);
                        if (readerFeature != null && readerFeature.getReadingBook() == null && WelcomeDialog.hasNewShowableSplash()) {
                            new WelcomeDialog(topActivity, false, new StateListener(this) {
                                /* renamed from: b */
                                final /* synthetic */ C04265 f1393b;

                                public void onEnd(Uri uri) {
                                    if (uri != null) {
                                        readerFeature.navigateSmoothly(uri.toString());
                                    }
                                }
                            }).show();
                            return;
                        }
                    }
                }
                if (DkMainActivity.f1396d > 0) {
                    WelcomeDialog.fetchNewSplash();
                    return;
                }
                return;
            }
            DkMainActivity.f1396d = System.currentTimeMillis();
        }
    }

    @TargetApi(19)
    protected void onCreate(Bundle bundle) {
        if (VERSION.SDK_INT >= 19) {
            getWindow().addFlags(67108864);
        }
        f1396d = -1;
        f1394b = new WeakReference(this);
        if (isNewbieUser()) {
            DkApp.get().setAutoLogin(false);
        }
        this.f1397e = DkReaderController.from(this);
        setContentController(this.f1397e);
        super.onCreate(bundle);
    }

    protected final void attachBaseContext(Context context) {
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        if (!onOverrideConfiguration(configuration)) {
            super.attachBaseContext(context);
        } else if (VERSION.SDK_INT >= 17) {
            super.attachBaseContext(context);
            applyOverrideConfiguration(configuration);
        } else {
            final Resources resources = new Resources(context.getResources().getAssets(), context.getResources().getDisplayMetrics(), configuration);
            super.attachBaseContext(new ContextWrapper(this, context) {
                /* renamed from: b */
                final /* synthetic */ DkMainActivity f1385b;

                public Resources getResources() {
                    return resources;
                }
            });
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.f1398f) {
            final C1367p activeScene = this.f1397e.activeScene();
            if (isNewbieUser() && (activeScene instanceof C1522i)) {
                new C1514a(this, new Runnable(this) {
                    /* renamed from: b */
                    final /* synthetic */ DkMainActivity f1388b;

                    /* renamed from: com.duokan.reader.DkMainActivity$2$1 */
                    class C04211 implements C0420b {
                        /* renamed from: a */
                        final /* synthetic */ C04222 f1386a;

                        C04211(C04222 c04222) {
                            this.f1386a = c04222;
                        }

                        public void onLoginOk(C0672a c0672a) {
                        }

                        public void onLoginError(C0672a c0672a, String str) {
                        }
                    }

                    public void run() {
                        if (activeScene.isActive()) {
                            MiAccount miAccount = (MiAccount) C0709k.m3476a().m3502b(MiAccount.class);
                            if (!MiAccount.m3186b(this.f1388b)) {
                                return;
                            }
                            if (miAccount == null || miAccount.mo839i()) {
                                C0709k.m3476a().m3506c(new C04211(this));
                            }
                        }
                    }
                }).show();
            } else if (!DkApp.get().isUiReady() || WelcomeDialog.hasNewShowableSplash()) {
                new WelcomeDialog(this, !TextUtils.equals(getIntent().getAction(), "android.intent.action.MAIN"), new C04233(this)).show();
            } else {
                WelcomeDialog.fetchNewSplash();
            }
            listenRunningState();
            this.f1398f = false;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.f1397e = null;
        setContentView(new FrameLayout(this));
        if (f1394b.get() == this) {
            f1394b.clear();
        }
        if (DkApp.get().inCtaMode() && !(DkApp.get().isWebAccessEnabled() && DkApp.get().isWebAccessConfirmed())) {
            Process.killProcess(Process.myPid());
        }
        System.gc();
    }

    protected void onPause() {
        super.onPause();
        if (DkReader.get().isReady()) {
            startDownloadService();
            startBookUploadService();
        }
    }

    protected void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        DkApp.get().runWhenAppReady(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ DkMainActivity f1391b;

            public void run() {
                this.f1391b.f1397e.navigate(intent);
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    protected boolean onOverrideConfiguration(Configuration configuration) {
        Locale userChosenLocale = DkApp.get().getUserChosenLocale();
        if (userChosenLocale == null) {
            userChosenLocale = DkApp.get().getSystemLocale();
        }
        if (configuration.locale.equals(userChosenLocale)) {
            return false;
        }
        configuration.locale = userChosenLocale;
        return true;
    }

    public static boolean isAlive() {
        if (f1394b.get() == null || ((DkMainActivity) f1394b.get()).isFinishing()) {
            return false;
        }
        return true;
    }

    private static void listenRunningState() {
        if (f1395c == null) {
            f1395c = new C04265();
            ManagedApp.get().addOnRunningStateChangedListener(f1395c);
        }
    }

    private void startDownloadService() {
        startService(new Intent(this, DownloadService.class));
    }

    private void startBookUploadService() {
        startService(new Intent(this, BookUploadService.class));
    }

    private boolean isNewbieUser() {
        Object action = getIntent().getAction();
        return (TextUtils.isEmpty(action) || action.equals("android.intent.action.MAIN")) && cn.m3452b();
    }
}
