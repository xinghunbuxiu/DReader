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

import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.core.app.m;
import com.duokan.core.app.w;
import com.duokan.reader.WelcomeDialog.StateListener;
import com.duokan.reader.domain.bookshelf.BookUploadService;
import com.duokan.reader.domain.downloadcenter.DownloadService;

import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DkMainActivity extends m {
    private static WeakReference b = new WeakReference(null);
    private static w c = null;
    private static long d = -1;
    private DkReaderController e = null;
    private boolean f = true;

    @TargetApi(19)
    protected void onCreate(Bundle bundle) {
        if (VERSION.SDK_INT >= 19) {
            getWindow().addFlags(67108864);
        }
        d = -1;
        b = new WeakReference(this);
        this.e = DkReaderController.from(this);
        setContentController(this.e);
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
                final /* synthetic */ DkMainActivity b;

                public Resources getResources() {
                    return resources;
                }
            });
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.f) {
            if (!DkApp.get().isUiReady() || WelcomeDialog.hasNewShowableSplash()) {
                new WelcomeDialog(this, !TextUtils.equals(getIntent().getAction(), "android.intent.action.MAIN"), new StateListener(this) {
                    final /* synthetic */ DkMainActivity a;

                    {
                        this.a = r1;
                    }

                    public void onEnd(Uri uri) {
                        if (uri != null) {
                            Intent intent = new Intent();
                            intent.setComponent(new ComponentName(DkApp.get(), DkReader.get().getMainActivityClass()));
                            intent.setAction("android.intent.action.VIEW");
                            intent.setData(uri);
                            this.a.startActivity(intent);
                        }
                        WelcomeDialog.fetchNewSplash();
                    }
                }).show();
            } else {
                WelcomeDialog.fetchNewSplash();
            }
            listenRunningState();
            this.f = false;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.e = null;
        setContentView(new FrameLayout(this));
        if (b.get() == this) {
            b.clear();
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
            final /* synthetic */ DkMainActivity b;

            public void run() {
                this.b.e.navigate(intent);
            }
        });
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
        if (b.get() == null || ((DkMainActivity) b.get()).isFinishing()) {
            return false;
        }
        return true;
    }

    private static void listenRunningState() {
        if (c == null) {
            c = new w() {
                public void onRunningStateChanged(ManagedApp managedApp, RunningState runningState, RunningState runningState2) {
                    if (runningState2 == RunningState.FOREGROUND) {
                        if (DkReader.get().isReady() && DkMainActivity.d >= 0 && System.currentTimeMillis() - DkMainActivity.d >= TimeUnit.MINUTES.toMillis(5)) {
                            Context topActivity = managedApp.getTopActivity();
                            if (topActivity != null) {
                                final ReaderFeature readerFeature = (ReaderFeature) managedApp.getContext().queryFeature(ReaderFeature.class);
                                if (readerFeature != null && readerFeature.getReadingBook() == null && WelcomeDialog.hasNewShowableSplash()) {
                                    new WelcomeDialog(topActivity, false, new StateListener(this) {
                                        final /* synthetic */ AnonymousClass4 b;

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
                        if (DkMainActivity.d > 0) {
                            WelcomeDialog.fetchNewSplash();
                            return;
                        }
                        return;
                    }
                    DkMainActivity.d = System.currentTimeMillis();
                }
            };
            ManagedApp.get().addOnRunningStateChangedListener(c);
        }
    }

    private void startDownloadService() {
        startService(new Intent(this, DownloadService.class));
    }

    private void startBookUploadService() {
        startService(new Intent(this, BookUploadService.class));
    }
}
