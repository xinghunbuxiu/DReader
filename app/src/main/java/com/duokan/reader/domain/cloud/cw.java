package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.p035a.C0517a;

class cw implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0517a f3842a;
    /* renamed from: b */
    final /* synthetic */ DkUserPurchasedFictionsManager f3843b;

    cw(DkUserPurchasedFictionsManager dkUserPurchasedFictionsManager, C0517a c0517a) {
        this.f3843b = dkUserPurchasedFictionsManager;
        this.f3842a = c0517a;
    }

    public void run() {
        if (this.f3843b.f3614f.m2233a()) {
            this.f3843b.f3614f.m2231a(this.f3842a);
            if (this.f3843b.f3616h.f3888a) {
                this.f3843b.f3614f.mo730a(null);
                this.f3843b.f3614f.m2234b();
                return;
            }
            new cx(this, dq.f3887a, DkUserPurchasedFictionsManager.m5092g()).open();
            return;
        }
        this.f3843b.f3614f.m2231a(this.f3842a);
    }
}
