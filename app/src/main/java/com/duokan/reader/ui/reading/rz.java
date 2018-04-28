package com.duokan.reader.ui.reading;

import com.duokan.core.sys.IdleHandlerListener;

class rz implements IdleHandlerListener {
    /* renamed from: a */
    final /* synthetic */ ry f10923a;

    rz(ry ryVar) {
        this.f10923a = ryVar;
    }

    public boolean idleRun() {
        this.f10923a.f10922a.f9279c.mo2103b(new sa(this));
        return false;
    }
}
