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

import com.duokan.core.app.BaseActivity;
import com.duokan.core.app.IActivityRunStatusChanged;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.reader.WelcomeDialog.StateListener;
import com.duokan.reader.domain.bookshelf.BookUploadService;
import com.duokan.reader.domain.downloadcenter.DownloadService;

import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DkMainActivity extends BaseActivity {
    private static WeakReference weakReference = new WeakReference(null);
    private static IActivityRunStatusChanged runStatusChanged = null;
    private static long cTime = -1;
    private DkReaderController controller = null;
    private boolean first = true;

    @TargetApi(19)
    protected void onCreate(Bundle bundle) {
        if (VERSION.SDK_INT >= 19) {
            getWindow().addFlags(67108864);
        }
        cTime = -1;
        weakReference = new WeakReference(this);
        this.controller = DkReaderController.from(this);
        setContentController(this.controller);
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
            super.attachBaseContext(new ContextWrapper(context) {

                public Resources getResources() {
                    return resources;
                }
            });
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.first) {
            if (!DkApp.get().isUiReady() || WelcomeDialog.hasNewShowableSplash()) {
                new WelcomeDialog(this, !TextUtils.equals(getIntent().getAction(), "android.intent.action.MAIN"), new StateListener() {

                    public void onEnd(Uri uri) {
                        if (uri != null) {
                            Intent intent = new Intent();
                            intent.setComponent(new ComponentName(getApplication(), DkReader.get().getMainActivityClass()));
                            intent.setAction("android.intent.action.VIEW");
                            intent.setData(uri);
                            startActivity(intent);
                        }
                        WelcomeDialog.fetchNewSplash();
                    }
                }).show();
            } else {
                WelcomeDialog.fetchNewSplash();
            }
            listenRunningState();
            this.first = false;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.controller = null;
        setContentView(new FrameLayout(this));
        if (weakReference.get() == this) {
            weakReference.clear();
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
        DkApp.get().runWhenAppReady(new Runnable() {

            public void run() {
                controller.navigate(intent);
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
        if (weakReference.get() == null || ((DkMainActivity) weakReference.get()).isFinishing()) {
            return false;
        }
        return true;
    }

    private static void listenRunningState() {
        if (runStatusChanged == null) {
            runStatusChanged = new IActivityRunStatusChanged() {
                public void onRunningStateChanged(ManagedApp managedApp, RunningState runningState, RunningState runningState2) {
                    if (runningState2 == RunningState.FOREGROUND) {
                        if (DkReader.get().isReady() && cTime >= 0 && System.currentTimeMillis() - cTime >= TimeUnit.MINUTES.toMillis(5)) {
                            Context topActivity = managedApp.getTopActivity();
                            if (topActivity != null) {
                                final ReaderFeature readerFeature = managedApp.getContext().queryFeature(ReaderFeature.class);
                                if (readerFeature != null && readerFeature.getReadingBook() == null && WelcomeDialog.hasNewShowableSplash()) {
                                    new WelcomeDialog(topActivity, false, new StateListener() {
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
                        if (cTime > 0) {
                            WelcomeDialog.fetchNewSplash();
                            return;
                        }
                        return;
                    }
                    cTime = System.currentTimeMillis();
                }
            };
            ManagedApp.get().addOnRunningStateChangedListener(runStatusChanged);
        }
    }

    private void startDownloadService() {
        startService(new Intent(this, DownloadService.class));
    }

    private void startBookUploadService() {
        startService(new Intent(this, BookUploadService.class));
    }
}
