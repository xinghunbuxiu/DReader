package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.domain.account.al;

class cb implements C0517a<Void> {
    /* renamed from: a */
    final /* synthetic */ ca f3804a;

    cb(ca caVar) {
        this.f3804a = caVar;
    }

    /* renamed from: a */
    public void m5376a(Void voidR) {
        al e = DkUserPurchasedBooksManager.m5051h();
        new cc(this, e.f2360a, cg.f3811a, e).open();
    }

    /* renamed from: a */
    public void mo729a(int i, String str) {
        this.f3804a.f3801b.mo729a(i, str);
    }
}
