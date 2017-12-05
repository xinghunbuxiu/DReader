package com.duokan.reader.ui.reading;

import com.duokan.core.sys.IdleStatus;

class qz implements IdleStatus {
    final /* synthetic */ qy a;

    qz(qy qyVar) {
        this.a = qyVar;
    }

    public boolean idleRun() {
        this.a.d.a.b(new xh(this.a.d.a.getContext(), this.a.d.a.e, this.a.d.a.G, this.a.a, this.a.b, this.a.c));
        return false;
    }
}
