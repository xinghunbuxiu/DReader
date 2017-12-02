package com.duokan.core.app;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

class u implements ActivityLifecycleCallbacks {
    final /* synthetic */ ManagedApp a;

    u(ManagedApp managedApp) {
        this.a = managedApp;
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityResumed(Activity activity) {
        this.a.onActivityResumed(activity);
    }

    public void onActivityPaused(Activity activity) {
        this.a.onActivityPaused(activity);
    }

    public void onActivityDestroyed(Activity activity) {
        this.a.onActivityDestroyed(activity);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        this.a.onActivityCreated(activity, bundle);
    }
}
