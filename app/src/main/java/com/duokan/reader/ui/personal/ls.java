package com.duokan.reader.ui.personal;

import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;

class ls implements C0517a<Void> {
    /* renamed from: a */
    final /* synthetic */ boolean f8903a;
    /* renamed from: b */
    final /* synthetic */ kq f8904b;
    /* renamed from: c */
    final /* synthetic */ lc f8905c;

    ls(lc lcVar, boolean z, kq kqVar) {
        this.f8905c = lcVar;
        this.f8903a = z;
        this.f8904b = kqVar;
    }

    /* renamed from: a */
    public void m12216a(Void voidR) {
        if (this.f8903a || DkUserPurchasedFictionsManager.m5072a().m5110d()) {
            DkUserPurchasedFictionsManager.m5072a().m5106b(true, false, new lt(this));
            return;
        }
        this.f8904b.f8827g = false;
        this.f8905c.m12140a(this.f8904b);
    }

    /* renamed from: a */
    public void mo729a(int i, String str) {
        this.f8904b.f8827g = false;
        this.f8905c.m12140a(this.f8904b);
    }
}
