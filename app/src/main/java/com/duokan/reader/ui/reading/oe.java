package com.duokan.reader.ui.reading;

import com.duokan.core.sys.IdleStatus;

class oe implements IdleStatus {
    final /* synthetic */ od a;

    oe(od odVar) {
        this.a = odVar;
    }

    public boolean idleRun() {
        this.a.d.b.b(new of(this));
        return false;
    }
}
