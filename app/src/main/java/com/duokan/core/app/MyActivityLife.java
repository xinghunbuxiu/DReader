package com.duokan.core.app;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

class MyActivityLife implements ActivityLifecycleCallbacks {
    final ManagedApp managedApp;

    MyActivityLife(ManagedApp managedApp) {
        this.managedApp = managedApp;
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityResumed(Activity activity) {
        this.managedApp.onActivityResumed(activity);
    }

    public void onActivityPaused(Activity activity) {
        this.managedApp.onActivityPaused(activity);
    }

    public void onActivityDestroyed(Activity activity) {
        this.managedApp.onActivityDestroyed(activity);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        this.managedApp.onActivityCreated(activity, bundle);
    }
}
