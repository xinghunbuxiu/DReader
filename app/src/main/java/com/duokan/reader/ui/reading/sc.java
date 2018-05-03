package com.duokan.reader.ui.reading;

import com.duokan.core.app.ApplicationsStateCallbacks;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.reader.domain.statistics.dailystats.C1167a;

class sc implements ApplicationsStateCallbacks {
    /* renamed from: a */
    final /* synthetic */ qr f10931a;

    sc(qr qrVar) {
        this.f10931a = qrVar;
    }

    public void onRunningStateChanged(ManagedApp managedApp, RunningState runningState, RunningState runningState2) {
        if (runningState2 != RunningState.FOREGROUND) {
            C1167a.m8671d().m8676a(this.f10931a.f9282f, 1, this.f10931a.f9266E, this.f10931a.f9267F);
        }
    }
}
