package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.document.aa;
import com.duokan.reader.domain.document.n;
import com.duokan.reader.domain.document.txt.z;

class ld implements z {
    final /* synthetic */ z a;
    final /* synthetic */ lb b;

    ld(lb lbVar, z zVar) {
        this.b = lbVar;
        this.a = zVar;
    }

    public void a(n nVar, aa aaVar) {
        if (this.a != null) {
            this.a.a(nVar, aaVar);
        }
    }

    public void a(n nVar) {
        if (this.a != null) {
            this.a.a(nVar);
        }
    }

    public void b(n nVar) {
        this.b.a.decrementAndGet();
        if (this.a != null) {
            this.a.b(nVar);
        }
    }

    public void c(n nVar) {
        this.b.a.decrementAndGet();
        if (this.a != null) {
            this.a.c(nVar);
        }
    }

    public void d(n nVar) {
        if (this.a != null) {
            this.a.d(nVar);
        }
    }

    public void e(n nVar) {
        if (this.a != null) {
            this.a.e(nVar);
        }
    }

    public void f(n nVar) {
        if (this.a != null) {
            this.a.f(nVar);
        }
    }
}
