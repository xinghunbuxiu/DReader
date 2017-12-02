package com.duokan.reader.ui.bookshelf;

import com.duokan.core.sys.t;
import com.duokan.core.ui.dv;

class cm implements Runnable {
    public final int a;
    final /* synthetic */ bz b;

    public cm(bz bzVar, int i) {
        this.b = bzVar;
        this.a = (i > 0 ? 1 : -1) * dv.b(bzVar.a.getContext(), 7.0f);
    }

    public void run() {
        if (this.b.o != this) {
            return;
        }
        if ((this.b.j.c_() || this.a >= 0) && (this.b.j.d_() || this.a <= 0)) {
            this.b.o = null;
            return;
        }
        this.b.j.a(0, this.a);
        t.b((Runnable) this);
    }
}
