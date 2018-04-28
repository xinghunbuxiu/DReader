package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.p035a.C0517a;

class df implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0517a f3870a;
    /* renamed from: b */
    final /* synthetic */ DkUserPurchasedFictionsManager f3871b;

    df(DkUserPurchasedFictionsManager dkUserPurchasedFictionsManager, C0517a c0517a) {
        this.f3871b = dkUserPurchasedFictionsManager;
        this.f3870a = c0517a;
    }

    public void run() {
        this.f3870a.mo729a(-1, "");
    }
}
