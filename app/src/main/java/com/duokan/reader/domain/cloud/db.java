package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.p035a.C0517a;

class db implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0517a f3855a;
    /* renamed from: b */
    final /* synthetic */ DkUserPurchasedFictionsManager f3856b;

    db(DkUserPurchasedFictionsManager dkUserPurchasedFictionsManager, C0517a c0517a) {
        this.f3856b = dkUserPurchasedFictionsManager;
        this.f3855a = c0517a;
    }

    public void run() {
        this.f3855a.mo729a(-1, "");
    }
}
