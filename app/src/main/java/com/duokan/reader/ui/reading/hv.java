package com.duokan.reader.ui.reading;

import com.duokan.core.sys.ag;
import com.duokan.reader.domain.bookshelf.BookPackageType;
import com.duokan.reader.domain.bookshelf.fp;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.epub.C0952s;
import com.duokan.reader.domain.document.epub.av;
import java.util.LinkedList;
import java.util.List;

class hv implements ag<as> {
    /* renamed from: a */
    final /* synthetic */ ag f10354a;
    /* renamed from: b */
    final /* synthetic */ boolean f10355b;
    /* renamed from: c */
    final /* synthetic */ ht f10356c;

    hv(ht htVar, ag agVar, boolean z) {
        this.f10356c = htVar;
        this.f10354a = agVar;
        this.f10355b = z;
    }

    public /* synthetic */ void run(Object obj) {
        m14395a((as) obj);
    }

    /* renamed from: a */
    public void m14395a(as asVar) {
        if (asVar == null) {
            this.f10354a.run(null);
        } else if (this.f10356c.m13110b(asVar)) {
            this.f10354a.run(asVar);
        } else {
            ak l = asVar.mo1332l();
            asVar.mo1285H();
            if (this.f10356c.f10351a.h.mo1448b() || !this.f10356c.mo2186b(l)) {
                this.f10354a.run(null);
                return;
            }
            fp fpVar = (fp) this.f10356c.f10351a.f;
            C0952s h = this.f10356c.f10351a.m14327C();
            long[] a = this.f10356c.mo2358a(l);
            if (a.length < 1) {
                this.f10354a.run(null);
            } else if (fpVar.m4247s() == BookPackageType.EPUB_OPF) {
                List linkedList = new LinkedList();
                for (long d : a) {
                    av d2 = h.m7064d(d);
                    if (d2 != null) {
                        linkedList.push(d2);
                    }
                }
                this.f10356c.f10351a.m14337b(linkedList, new hw(this, l));
            } else {
                this.f10354a.run(null);
            }
        }
    }
}
