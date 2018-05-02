package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.h;

class bm implements h {
    final /* synthetic */ DkUserPurchasedBooksManager a;

    bm(DkUserPurchasedBooksManager dkUserPurchasedBooksManager) {
        this.a = dkUserPurchasedBooksManager;
    }

    public void a(a aVar) {
        this.a.h = new ct();
    }

    public void b(a aVar) {
        this.a.a(false, false);
    }

    public void c(a aVar) {
        ct ctVar = new ct();
        ctVar.a = true;
        ctVar.b = true;
        this.a.h = ctVar;
        this.a.f();
    }

    public void d(a aVar) {
    }
}
