package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.domain.account.al;

class dd implements C0517a<Void> {
    /* renamed from: a */
    final /* synthetic */ dc f3861a;

    dd(dc dcVar) {
        this.f3861a = dcVar;
    }

    /* renamed from: a */
    public void m5426a(Void voidR) {
        al e = DkUserPurchasedFictionsManager.m5092g();
        new de(this, e.f2360a, dq.f3887a, e).open();
    }

    /* renamed from: a */
    public void mo729a(int i, String str) {
        this.f3861a.f3858b.mo729a(i, str);
    }
}
