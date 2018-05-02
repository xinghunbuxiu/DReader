package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.a.a;

class cd implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ DkUserPurchasedBooksManager b;

    cd(DkUserPurchasedBooksManager dkUserPurchasedBooksManager, a aVar) {
        this.b = dkUserPurchasedBooksManager;
        this.a = aVar;
    }

    public void run() {
        if (this.b.g.a()) {
            this.b.g.a(this.a);
            if (this.b.h.b) {
                this.b.g.a(null);
                this.b.g.b();
                return;
            }
            this.b.a(new ce(this));
            return;
        }
        this.b.g.a(this.a);
    }
}
