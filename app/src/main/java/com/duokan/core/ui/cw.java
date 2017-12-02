package com.duokan.core.ui;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

class cw implements ActivityLifecycleCallbacks {
    final /* synthetic */ cv a;

    cw(cv cvVar) {
        this.a = cvVar;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
        if (activity == this.a.f) {
            this.a.dismissNow();
        }
    }
}
