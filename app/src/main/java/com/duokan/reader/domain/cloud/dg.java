package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;

class dg implements C0666x {
    /* renamed from: a */
    final /* synthetic */ boolean f3872a;
    /* renamed from: b */
    final /* synthetic */ boolean f3873b;
    /* renamed from: c */
    final /* synthetic */ C0517a f3874c;
    /* renamed from: d */
    final /* synthetic */ DkUserPurchasedFictionsManager f3875d;

    dg(DkUserPurchasedFictionsManager dkUserPurchasedFictionsManager, boolean z, boolean z2, C0517a c0517a) {
        this.f3875d = dkUserPurchasedFictionsManager;
        this.f3872a = z;
        this.f3873b = z2;
        this.f3874c = c0517a;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        this.f3875d.m5103b(new dh(this));
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f3874c.mo729a(-1, "");
    }
}
