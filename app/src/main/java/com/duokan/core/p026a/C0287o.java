package com.duokan.core.p026a;

import com.duokan.core.app.C0286x;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;


class C0287o implements C0286x {
    
    final  C0285n f483a;

    C0287o(C0285n c0285n) {
        this.f483a = c0285n;
    }

    public void onRunningStateChanged(ManagedApp managedApp, RunningState runningState, RunningState runningState2) {
        if (runningState2.ordinal() > RunningState.BACKGROUND.ordinal()) {
            this.f483a.m661h();
        } else if (runningState2.ordinal() < runningState.ordinal()) {
            this.f483a.m664i();
        }
    }
}
