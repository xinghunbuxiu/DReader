package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.a.a;

class cb implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ DkUserPurchasedBooksManager b;

    cb(DkUserPurchasedBooksManager dkUserPurchasedBooksManager, a aVar) {
        this.b = dkUserPurchasedBooksManager;
        this.a = aVar;
    }

    public void run() {
        if (this.b.f.a()) {
            this.b.f.a(this.a);
            if (this.b.h.a) {
                this.b.f.a(null);
                this.b.f.b();
                return;
            }
            new cc(this, DkUserPurchasedBooksManager.h()).open();
            return;
        }
        this.b.f.a(this.a);
    }
}
