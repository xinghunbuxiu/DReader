package com.duokan.reader.ui.reading;

import com.duokan.c.j;
import com.duokan.reader.domain.bookshelf.BookLimitType;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.fv;
import com.duokan.reader.domain.document.epub.ag;
import com.duokan.reader.domain.document.epub.ap;
import com.duokan.reader.domain.document.epub.s;
import com.duokan.reader.domain.document.l;

class hn implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ hj b;

    hn(hj hjVar, int i) {
        this.b = hjVar;
        this.a = i;
    }

    public void run() {
        if (!this.b.a.q) {
            s h = this.b.a.C();
            BookType H = this.b.H();
            BookLimitType I = this.b.I();
            this.b.a.r = this.b.a.f.o();
            this.b.a.s = this.b.a.f.p();
            if (H == BookType.SERIAL) {
                if (an.a(this.a, 2048) && ((fv) this.b.a.f).a(h.C())) {
                    if (h.D() != ((long) ((fv) this.b.a.f).aZ())) {
                        h.a(null);
                        this.b.a(true);
                    } else {
                        this.b.j(true);
                    }
                }
                if (an.a(this.a, 16)) {
                    this.b.j(true);
                }
            } else if (H == BookType.NORMAL) {
                if (I != this.b.a.s || (this.a & 128) == 128) {
                    l lVar = (ap) this.b.a.f.b();
                    if (h.F().equals(lVar)) {
                        this.b.j(true);
                        return;
                    }
                    if (this.b.a.f.Q() && !((fv) this.b.a.f).aX() && (h.F() instanceof ag) && !(lVar instanceof ag)) {
                        com.duokan.reader.ui.general.ap apVar = new com.duokan.reader.ui.general.ap(this.b.a.getContext());
                        apVar.setOkLabel(j.general__shared__iknow);
                        apVar.setCancelOnBack(false);
                        apVar.setCancelOnTouchOutside(false);
                        apVar.setPrompt(j.reading__shared__timeout);
                        apVar.show();
                    }
                    h.a(lVar);
                    this.b.a(true);
                }
            } else if (H != BookType.TRIAL) {
            } else {
                if (this.b.a.r == BookType.NORMAL) {
                    h.a(null);
                    this.b.a(true);
                } else if (an.a(this.a, 128)) {
                    this.b.a(true);
                }
            }
        }
    }
}
