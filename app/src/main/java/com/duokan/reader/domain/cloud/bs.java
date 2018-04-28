package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.p035a.C0517a;

class bs implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0517a f3779a;
    /* renamed from: b */
    final /* synthetic */ DkUserPurchasedBooksManager f3780b;

    bs(DkUserPurchasedBooksManager dkUserPurchasedBooksManager, C0517a c0517a) {
        this.f3780b = dkUserPurchasedBooksManager;
        this.f3779a = c0517a;
    }

    public void run() {
        if (this.f3780b.f3607g.m2233a()) {
            this.f3780b.f3607g.m2231a(this.f3779a);
            if (this.f3780b.f3608h.f3813b) {
                this.f3780b.f3607g.mo730a(null);
                this.f3780b.f3607g.m2234b();
                return;
            }
            this.f3780b.m5053a(new bt(this));
            return;
        }
        this.f3780b.f3607g.m2231a(this.f3779a);
    }
}
