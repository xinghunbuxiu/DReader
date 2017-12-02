package com.duokan.core.app;

import com.duokan.core.app.ManagedApp.RunningState;

class v implements Runnable {
    final /* synthetic */ RunningState a;
    final /* synthetic */ ManagedApp b;

    v(ManagedApp managedApp, RunningState runningState) {
        this.b = managedApp;
        this.a = runningState;
    }

    public void run() {
        if (this.b.i == this) {
            this.b.runningState(this.a);
        }
    }
}
