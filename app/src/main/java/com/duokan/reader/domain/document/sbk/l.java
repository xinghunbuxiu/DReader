package com.duokan.reader.domain.document.sbk;

import com.duokan.reader.domain.document.a;
import com.duokan.reader.domain.document.d;
import com.duokan.reader.domain.document.g;

class l extends e {
    final /* synthetic */ f b;
    private String c;
    private d[] d;

    private l(f fVar) {
        this.b = fVar;
        this.c = "";
        this.d = new d[0];
    }

    public /* synthetic */ g b(a aVar) {
        return c(aVar);
    }

    protected void a(q qVar) {
        d[] dVarArr = new d[qVar.a()];
        for (int i = 0; i < dVarArr.length; i++) {
            dVarArr[i] = new d(this.b, 0, i, i, qVar.a(i));
        }
        this.d = dVarArr;
    }

    public String a() {
        return this.c;
    }

    public void a(String str) {
        this.c = str;
    }

    public g[] b() {
        return this.d;
    }

    public int c() {
        return this.d.length;
    }

    public g a(long j) {
        if (j < 0 || j >= ((long) this.d.length)) {
            return null;
        }
        return this.d[(int) j];
    }

    public d c(a aVar) {
        if (!this.b.d(aVar) || !aVar.e()) {
            return null;
        }
        aVar = aVar instanceof b ? (b) aVar : aVar instanceof t ? ((t) aVar).j() : null;
        if (aVar == null || this.d.length < 1) {
            return null;
        }
        d dVar = (d) a(this.d, (d) aVar);
        if (dVar == null) {
            return this.d[0];
        }
        return dVar;
    }

    protected boolean a(g gVar, d dVar) {
        return gVar.f().c(dVar);
    }
}
