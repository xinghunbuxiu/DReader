package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;

import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.domain.document.aa;
import com.duokan.reader.domain.document.n;
import com.duokan.reader.domain.document.sbk.o;

class kh implements o {
    final /* synthetic */ o a;
    final /* synthetic */ jv b;

    kh(jv jvVar, o oVar) {
        this.b = jvVar;
        this.a = oVar;
    }

    public void a(n nVar, aa aaVar) {
        if (this.a != null) {
            this.a.a(nVar, aaVar);
        }
    }

    public void a(n nVar) {
        if (!(TextUtils.isEmpty(this.b.I()) || this.b.I().equals(this.b.M()))) {
            this.b.h(this.b.I());
        }
        if (this.a != null) {
            this.a.a(nVar);
        }
    }

    public void b(n nVar) {
        this.b.a.decrementAndGet();
        if (this.a != null) {
            this.a.b(nVar);
        }
        this.b.bq();
    }

    public void c(n nVar) {
        this.b.a.decrementAndGet();
        if (this.a != null) {
            this.a.c(nVar);
        }
        this.b.bq();
        DkUserPurchasedFictionsManager.a().d(this.b.H());
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
