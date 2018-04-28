package com.duokan.reader.ui.personal;

import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;

class lq implements C0517a<Void> {
    /* renamed from: a */
    final /* synthetic */ boolean f8899a;
    /* renamed from: b */
    final /* synthetic */ kq f8900b;
    /* renamed from: c */
    final /* synthetic */ lc f8901c;

    lq(lc lcVar, boolean z, kq kqVar) {
        this.f8901c = lcVar;
        this.f8899a = z;
        this.f8900b = kqVar;
    }

    /* renamed from: a */
    public void m12210a(Void voidR) {
        if (this.f8899a || DkUserPurchasedBooksManager.m5029a().m5070d()) {
            DkUserPurchasedBooksManager.m5029a().m5061a(true, false, new lr(this));
            return;
        }
        this.f8900b.f8826f = false;
        this.f8901c.m12140a(this.f8900b);
    }

    /* renamed from: a */
    public void mo729a(int i, String str) {
        this.f8900b.f8826f = false;
        this.f8901c.m12140a(this.f8900b);
    }
}
