package com.duokan.reader.ui.reading;

import com.duokan.core.sys.ag;
import com.duokan.reader.domain.bookshelf.BookPackageType;
import com.duokan.reader.domain.bookshelf.fv;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.epub.av;
import com.duokan.reader.domain.document.epub.s;

import java.util.LinkedList;
import java.util.List;

class hl implements ag {
    final /* synthetic */ ag a;
    final /* synthetic */ boolean b;
    final /* synthetic */ hj c;

    hl(hj hjVar, ag agVar, boolean z) {
        this.c = hjVar;
        this.a = agVar;
        this.b = z;
    }

    public void a(as asVar) {
        if (asVar == null) {
            this.a.a(null);
        } else if (this.c.b(asVar)) {
            this.a.a(asVar);
        } else {
            ak l = asVar.l();
            asVar.H();
            if (this.c.a.h.b() || !this.c.b(l)) {
                this.a.a(null);
                return;
            }
            fv fvVar = (fv) this.c.a.f;
            s h = this.c.a.C();
            long[] a = this.c.a(l);
            if (a.length < 1) {
                this.a.a(null);
            } else if (fvVar.s() == BookPackageType.EPUB_OPF) {
                List linkedList = new LinkedList();
                for (long d : a) {
                    av d2 = h.d(d);
                    if (d2 != null) {
                        linkedList.push(d2);
                    }
                }
                this.c.a.b(linkedList, new hm(this, l));
            } else {
                this.a.a(null);
            }
        }
    }
}
