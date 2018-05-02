package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;

import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.domain.document.aa;
import com.duokan.reader.domain.document.epub.af;
import com.duokan.reader.domain.document.epub.s;
import com.duokan.reader.domain.document.n;

class gn implements af {
    final /* synthetic */ af a;
    final /* synthetic */ fv b;

    gn(fv fvVar, af afVar) {
        this.b = fvVar;
        this.a = afVar;
    }

    public void a(n nVar, aa aaVar) {
        if (this.a != null) {
            this.a.a(nVar, aaVar);
        }
    }

    public void a(n nVar) {
        String B = ((s) nVar).B();
        if (!(TextUtils.isEmpty(B) || B.equals(this.b.I()))) {
            this.b.f(B);
        }
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
        this.b.bv();
    }

    public void c(n nVar) {
        this.b.a.decrementAndGet();
        if (this.a != null) {
            this.a.c(nVar);
        }
        this.b.bv();
        if (this.b.k()) {
            DkUserPurchasedFictionsManager.a().d(this.b.H());
        } else {
            DkUserPurchasedBooksManager.a().e(this.b.H());
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
