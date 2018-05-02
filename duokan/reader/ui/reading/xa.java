package com.duokan.reader.ui.reading;

import com.duokan.core.sys.IdleStatus;

class xa implements IdleStatus {
    final /* synthetic */ ww a;

    xa(ww wwVar) {
        this.a = wwVar;
    }

    public boolean idleRun() {
        this.a.b(true);
        return false;
    }
}
