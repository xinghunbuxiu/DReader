package com.duokan.core.app;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

/* renamed from: com.duokan.core.app.v */
class C0318v implements ActivityLifecycleCallbacks {
    /* renamed from: a */
    final /* synthetic */ ManagedApp f542a;

    C0318v(ManagedApp managedApp) {
        this.f542a = managedApp;
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityResumed(Activity activity) {
        this.f542a.onActivityResumed(activity);
    }

    public void onActivityPaused(Activity activity) {
        this.f542a.onActivityPaused(activity);
    }

    public void onActivityDestroyed(Activity activity) {
        this.f542a.onActivityDestroyed(activity);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        this.f542a.onActivityCreated(activity, bundle);
    }
}
