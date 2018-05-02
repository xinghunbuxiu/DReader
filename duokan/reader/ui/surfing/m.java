package com.duokan.reader.ui.surfing;

import com.duokan.core.sys.IdleStatus;

class m implements IdleStatus {
    final /* synthetic */ l a;

    m(l lVar) {
        this.a = lVar;
    }

    public boolean idleRun() {
        if (this.a.a.a.isAttached()) {
            this.a.a.a.r();
        }
        return false;
    }
}
