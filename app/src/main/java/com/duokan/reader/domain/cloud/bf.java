package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.domain.account.al;

class bf implements C0517a<Void> {
    /* renamed from: a */
    final /* synthetic */ be f3747a;

    bf(be beVar) {
        this.f3747a = beVar;
    }

    /* renamed from: a */
    public void m5346a(Void voidR) {
        al e = DkUserPurchasedBooksManager.m5051h();
        new bg(this, e.f2360a, cg.f3811a, e).open();
    }

    /* renamed from: a */
    public void mo729a(int i, String str) {
        this.f3747a.f3745b.mo729a(i, str);
    }
}
