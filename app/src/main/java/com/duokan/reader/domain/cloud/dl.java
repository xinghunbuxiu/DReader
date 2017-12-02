package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.a.a;

class dl implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ DkUserPurchasedFictionsManager b;

    dl(DkUserPurchasedFictionsManager dkUserPurchasedFictionsManager, a aVar) {
        this.b = dkUserPurchasedFictionsManager;
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
            this.b.a(new dm(this));
            return;
        }
        this.b.g.a(this.a);
    }
}
