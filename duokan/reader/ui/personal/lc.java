package com.duokan.reader.ui.personal;

import com.duokan.reader.common.async.a.a;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;

class lc implements a {
    final /* synthetic */ boolean a;
    final /* synthetic */ kc b;
    final /* synthetic */ ko c;

    lc(ko koVar, boolean z, kc kcVar) {
        this.c = koVar;
        this.a = z;
        this.b = kcVar;
    }

    public void a(Void voidR) {
        if (this.a || DkUserPurchasedBooksManager.a().d()) {
            DkUserPurchasedBooksManager.a().a(true, false, new ld(this));
            return;
        }
        this.b.f = false;
        this.c.a(this.b);
    }

    public void a(int i, String str) {
        this.b.f = false;
        this.c.a(this.b);
    }
}
