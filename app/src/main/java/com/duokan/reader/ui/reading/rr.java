package com.duokan.reader.ui.reading;

import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.core.app.w;
import com.duokan.reader.domain.statistics.dailystats.a;

class rr implements w {
    final /* synthetic */ qh a;

    rr(qh qhVar) {
        this.a = qhVar;
    }

    public void onRunningStateChanged(ManagedApp managedApp, RunningState runningState, RunningState runningState2) {
        if (runningState2 != RunningState.FOREGROUND) {
            a.d().a(this.a.f, 1, this.a.E, this.a.F);
        }
    }
}
