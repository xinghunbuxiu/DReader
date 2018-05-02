package com.duokan.reader.ui.reading;

import com.duokan.core.sys.IdleStatus;

class sk implements IdleStatus {
    final /* synthetic */ sj a;

    sk(sj sjVar) {
        this.a = sjVar;
    }

    public boolean idleRun() {
        this.a.a.p();
        return false;
    }
}
