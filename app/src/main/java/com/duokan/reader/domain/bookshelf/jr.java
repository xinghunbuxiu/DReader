package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;

import com.duokan.reader.domain.document.a.n;
import com.duokan.reader.domain.document.aa;

class jr implements n {
    final /* synthetic */ n a;
    final /* synthetic */ jp b;

    jr(jp jpVar, n nVar) {
        this.b = jpVar;
        this.a = nVar;
    }

    public void a(com.duokan.reader.domain.document.n nVar, aa aaVar) {
        if (this.a != null) {
            this.a.a(nVar, aaVar);
        }
    }

    public void a(com.duokan.reader.domain.document.n nVar) {
        if (!(TextUtils.isEmpty(this.b.I()) || this.b.I().equals(this.b.M()))) {
            this.b.h(this.b.I());
        }
        if (this.a != null) {
            this.a.a(nVar);
        }
    }

    public void b(com.duokan.reader.domain.document.n nVar) {
        this.b.a.decrementAndGet();
        if (this.a != null) {
            this.a.b(nVar);
        }
    }

    public void c(com.duokan.reader.domain.document.n nVar) {
        this.b.a.decrementAndGet();
        if (this.a != null) {
            this.a.c(nVar);
        }
    }

    public void d(com.duokan.reader.domain.document.n nVar) {
        if (this.a != null) {
            this.a.d(nVar);
        }
    }

    public void e(com.duokan.reader.domain.document.n nVar) {
        if (this.a != null) {
            this.a.e(nVar);
        }
    }

    public void f(com.duokan.reader.domain.document.n nVar) {
        if (this.a != null) {
            this.a.f(nVar);
        }
    }
}
