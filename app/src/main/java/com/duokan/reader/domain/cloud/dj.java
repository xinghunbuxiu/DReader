package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.domain.account.al;

class dj implements C0517a<Void> {
    /* renamed from: a */
    final /* synthetic */ di f3880a;

    dj(di diVar) {
        this.f3880a = diVar;
    }

    /* renamed from: a */
    public void m5437a(Void voidR) {
        al e = DkUserPurchasedFictionsManager.m5092g();
        new dk(this, e.f2360a, dq.f3887a, e).open();
    }

    /* renamed from: a */
    public void mo729a(int i, String str) {
        this.f3880a.f3878b.mo729a(i, str);
    }
}
