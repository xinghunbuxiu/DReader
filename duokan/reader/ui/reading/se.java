package com.duokan.reader.ui.reading;

import com.duokan.core.sys.IdleStatus;

class se implements IdleStatus {
    final /* synthetic */ rx a;

    se(rx rxVar) {
        this.a = rxVar;
    }

    public boolean idleRun() {
        this.a.c.L();
        return false;
    }
}
