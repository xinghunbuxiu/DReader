package com.duokan.core.ui;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

class cw implements ActivityLifecycleCallbacks {
    /* renamed from: a */
    final /* synthetic */ cv f1117a;

    cw(cv cvVar) {
        this.f1117a = cvVar;
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
        if (activity == this.f1117a.f1098f) {
            this.f1117a.dismissNow();
        }
    }
}
