package com.duokan.reader.ui.reading;

import com.duokan.core.sys.IdleStatus;

class ro implements IdleStatus {
    final /* synthetic */ rn a;

    ro(rn rnVar) {
        this.a = rnVar;
    }

    public boolean idleRun() {
        this.a.a.c.b(new rp(this));
        return false;
    }
}
