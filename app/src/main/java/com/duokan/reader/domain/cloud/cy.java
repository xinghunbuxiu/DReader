package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.p035a.C0517a;

class cy implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0517a f3848a;
    /* renamed from: b */
    final /* synthetic */ DkUserPurchasedFictionsManager f3849b;

    cy(DkUserPurchasedFictionsManager dkUserPurchasedFictionsManager, C0517a c0517a) {
        this.f3849b = dkUserPurchasedFictionsManager;
        this.f3848a = c0517a;
    }

    public void run() {
        if (this.f3849b.f3615g.m2233a()) {
            this.f3849b.f3615g.m2231a(this.f3848a);
            if (this.f3849b.f3616h.f3889b) {
                this.f3849b.f3615g.mo730a(null);
                this.f3849b.f3615g.m2234b();
                return;
            }
            this.f3849b.m5094a(new cz(this));
            return;
        }
        this.f3849b.f3615g.m2231a(this.f3848a);
    }
}
