package com.duokan.reader.domain.document.a;

import com.duokan.kernel.pdflib.DkpBook;
import com.duokan.kernel.pdflib.DkpOutlineItem;
import com.duokan.reader.domain.document.a;
import com.duokan.reader.domain.document.d;
import com.duokan.reader.domain.document.g;
import com.duokan.reader.domain.document.h;

class j extends h {
    static final /* synthetic */ boolean b = (!d.class.desiredAssertionStatus());
    final /* synthetic */ d c;
    private String d;
    private c[] e;

    private j(d dVar) {
        this.c = dVar;
        this.d = "";
        this.e = new c[0];
    }

    public /* synthetic */ g b(a aVar) {
        return c(aVar);
    }

    protected void a(DkpBook dkpBook) {
        if (b || dkpBook != null) {
            DkpOutlineItem[] childOutlineItems = dkpBook.getChildOutlineItems(0);
            c[] cVarArr = new c[childOutlineItems.length];
            int i = 0;
            for (int i2 = 0; i2 < cVarArr.length; i2++) {
                cVarArr[i2] = new c(this.c, 0, i2, i, dkpBook, childOutlineItems[i2]);
                i += cVarArr[i2].a() + 1;
            }
            this.e = cVarArr;
            return;
        }
        throw new AssertionError();
    }

    public String a() {
        return this.d;
    }

    public void a(String str) {
        this.d = str;
    }

    public g[] b() {
        return this.e;
    }

    public int c() {
        return this.e.length;
    }

    public c c(a aVar) {
        if (!this.c.d(aVar) || !aVar.e()) {
            return null;
        }
        aVar = aVar instanceof a ? (a) aVar : aVar instanceof s ? ((s) aVar).j() : null;
        if (aVar == null || this.e.length < 1) {
            return null;
        }
        c cVar = (c) a(this.e, (d) aVar);
        if (cVar == null) {
            return this.e[0];
        }
        return cVar;
    }

    protected boolean a(g gVar, d dVar) {
        return gVar.f().c(dVar);
    }
}
