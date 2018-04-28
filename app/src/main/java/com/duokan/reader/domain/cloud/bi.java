package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.domain.account.al;

class bi implements C0517a<Void> {
    /* renamed from: a */
    final /* synthetic */ bh f3755a;

    bi(bh bhVar) {
        this.f3755a = bhVar;
    }

    /* renamed from: a */
    public void m5353a(Void voidR) {
        al e = DkUserPurchasedBooksManager.m5051h();
        new bj(this, e.f2360a, cg.f3811a, e).open();
    }

    /* renamed from: a */
    public void mo729a(int i, String str) {
        this.f3755a.f3753b.mo729a(i, str);
    }
}
