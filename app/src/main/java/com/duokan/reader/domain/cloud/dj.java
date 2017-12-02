package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.a.a;

class dj implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ DkUserPurchasedFictionsManager b;

    dj(DkUserPurchasedFictionsManager dkUserPurchasedFictionsManager, a aVar) {
        this.b = dkUserPurchasedFictionsManager;
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
            new dk(this, DkUserPurchasedFictionsManager.g()).open();
            return;
        }
        this.b.f.a(this.a);
    }
}
