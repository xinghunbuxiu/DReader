package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.domain.account.al;

class ct implements C0517a<Void> {
    /* renamed from: a */
    final /* synthetic */ cs f3836a;

    ct(cs csVar) {
        this.f3836a = csVar;
    }

    /* renamed from: a */
    public void m5415a(Void voidR) {
        al e = DkUserPurchasedFictionsManager.m5092g();
        new cu(this, e.f2360a, dq.f3887a, e).open();
    }

    /* renamed from: a */
    public void mo729a(int i, String str) {
        this.f3836a.f3834b.mo729a(i, str);
    }
}
