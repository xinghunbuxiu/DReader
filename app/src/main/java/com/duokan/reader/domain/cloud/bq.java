package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.p035a.C0517a;

class bq implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0517a f3773a;
    /* renamed from: b */
    final /* synthetic */ DkUserPurchasedBooksManager f3774b;

    bq(DkUserPurchasedBooksManager dkUserPurchasedBooksManager, C0517a c0517a) {
        this.f3774b = dkUserPurchasedBooksManager;
        this.f3773a = c0517a;
    }

    public void run() {
        if (this.f3774b.f3606f.m2233a()) {
            this.f3774b.f3606f.m2231a(this.f3773a);
            if (this.f3774b.f3608h.f3812a) {
                this.f3774b.f3606f.mo730a(null);
                this.f3774b.f3606f.m2234b();
                return;
            }
            new br(this, cg.f3811a, DkUserPurchasedBooksManager.m5051h()).open();
            return;
        }
        this.f3774b.f3606f.m2231a(this.f3773a);
    }
}
