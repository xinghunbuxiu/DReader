package com.duokan.reader.ui.reading;

import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.bookshelf.BookLimitType;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.fp;
import com.duokan.reader.domain.document.C0919l;
import com.duokan.reader.domain.document.epub.C0952s;
import com.duokan.reader.domain.document.epub.ag;
import com.duokan.reader.domain.document.epub.ap;

class hx implements Runnable {
    /* renamed from: a */
    final /* synthetic */ int f10359a;
    /* renamed from: b */
    final /* synthetic */ ht f10360b;

    hx(ht htVar, int i) {
        this.f10360b = htVar;
        this.f10359a = i;
    }

    public void run() {
        if (!this.f10360b.f10351a.q) {
            C0952s h = this.f10360b.f10351a.m14327C();
            BookType H = this.f10360b.m13037H();
            BookLimitType I = this.f10360b.m13038I();
            this.f10360b.f10351a.r = this.f10360b.f10351a.f.m4242o();
            this.f10360b.f10351a.s = this.f10360b.f10351a.f.m4243p();
            if (H == BookType.SERIAL) {
                if (an.m3740a(this.f10359a, 2048) && ((fp) this.f10360b.f10351a.f).m4486a(h.m7026C())) {
                    if (h.m7027D() != ((long) ((fp) this.f10360b.f10351a.f).bb())) {
                        h.mo1219a(null);
                        this.f10360b.mo2185a(true);
                    } else {
                        this.f10360b.mo2159j(true);
                    }
                }
                if (an.m3740a(this.f10359a, 16)) {
                    this.f10360b.mo2159j(true);
                }
            } else if (H == BookType.NORMAL) {
                if (I != this.f10360b.f10351a.s || (this.f10359a & 128) == 128) {
                    C0919l c0919l = (ap) this.f10360b.f10351a.f.mo1033b();
                    if (h.m7029F().equals(c0919l)) {
                        this.f10360b.mo2159j(true);
                        return;
                    }
                    if (this.f10360b.f10351a.f.m4166S() && !((fp) this.f10360b.f10351a.f).aZ() && (h.m7029F() instanceof ag) && !(c0919l instanceof ag)) {
                        com.duokan.reader.ui.general.ap apVar = new com.duokan.reader.ui.general.ap(this.f10360b.f10351a.getContext());
                        apVar.setOkLabelResid(C0258j.general__shared__iknow);
                        apVar.setCancelOnBack(false);
                        apVar.setCancelOnTouchOutside(false);
                        apVar.setPrompt(C0258j.reading__shared__timeout);
                        apVar.show();
                    }
                    h.mo1219a(c0919l);
                    this.f10360b.mo2185a(true);
                }
            } else if (H != BookType.TRIAL) {
            } else {
                if (this.f10360b.f10351a.r == BookType.NORMAL) {
                    h.mo1219a(null);
                    this.f10360b.mo2185a(true);
                } else if (an.m3740a(this.f10359a, 128)) {
                    this.f10360b.mo2185a(true);
                }
            }
        }
    }
}
