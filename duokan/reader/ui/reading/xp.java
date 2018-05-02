package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.jv;
import com.duokan.reader.domain.document.sbk.f;

class xp implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ xo b;

    xp(xo xoVar, int i) {
        this.b = xoVar;
        this.a = i;
    }

    public void run() {
        if (!this.b.a.q) {
            f b = this.b.a.C();
            this.b.a.r = this.b.a.f.o();
            this.b.a.s = this.b.a.f.p();
            if (an.a(this.a, 2048) && ((jv) this.b.a.f).a(b.B())) {
                if (b.C() != ((jv) this.b.a.f).aZ()) {
                    b.a(null);
                    this.b.a(true);
                } else {
                    this.b.j(true);
                }
            }
            if (an.a(this.a, 16)) {
                this.b.j(true);
            }
        }
    }
}
