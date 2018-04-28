package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;

class dc implements C0666x {
    /* renamed from: a */
    final /* synthetic */ boolean f3857a;
    /* renamed from: b */
    final /* synthetic */ C0517a f3858b;
    /* renamed from: c */
    final /* synthetic */ boolean f3859c;
    /* renamed from: d */
    final /* synthetic */ DkUserPurchasedFictionsManager f3860d;

    dc(DkUserPurchasedFictionsManager dkUserPurchasedFictionsManager, boolean z, C0517a c0517a, boolean z2) {
        this.f3860d = dkUserPurchasedFictionsManager;
        this.f3857a = z;
        this.f3858b = c0517a;
        this.f3859c = z2;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        this.f3860d.m5094a(new dd(this));
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f3858b.mo729a(-1, "");
    }
}
