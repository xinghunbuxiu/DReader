package com.duokan.reader.ui.bookshelf;

import com.duokan.core.sys.UThread;
import com.duokan.core.ui.dv;

class cr implements Runnable {
    /* renamed from: a */
    public final int f6289a;
    /* renamed from: b */
    final /* synthetic */ ce f6290b;

    public cr(ce ceVar, int i) {
        this.f6290b = ceVar;
        this.f6289a = (i > 0 ? 1 : -1) * dv.m1932b(ceVar.f6250a.getContext(), 7.0f);
    }

    public void run() {
        if (this.f6290b.f6263o != this) {
            return;
        }
        if ((this.f6290b.f6258j.d_() || this.f6289a >= 0) && (this.f6290b.f6258j.e_() || this.f6289a <= 0)) {
            this.f6290b.f6263o = null;
            return;
        }
        this.f6290b.f6258j.mo1662a(0, this.f6289a);
        UThread.post((Runnable) this);
    }
}
