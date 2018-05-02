package com.duokan.core.app;

import com.duokan.core.app.ManagedApp.RunningState;

/* renamed from: com.duokan.core.app.w */
class C0319w implements Runnable {
    /* renamed from: a */
    final /* synthetic */ RunningState f543a;
    /* renamed from: b */
    final /* synthetic */ ManagedApp f544b;

    C0319w(ManagedApp managedApp, RunningState runningState) {
        this.f544b = managedApp;
        this.f543a = runningState;
    }

    public void run() {
        if (this.f544b.f502i == this) {
            this.f544b.runningState(this.f543a);
        }
    }
}
