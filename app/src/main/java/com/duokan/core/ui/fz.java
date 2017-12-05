package com.duokan.core.ui;

import com.duokan.core.sys.IdleStatus;

class fz implements IdleStatus {
    final /* synthetic */ fy a;

    fz(fy fyVar) {
        this.a = fyVar;
    }

    public boolean idleRun() {
        this.a.a.a.j = null;
        this.a.a.b();
        return false;
    }
}
