package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;

class ca implements C0666x {
    /* renamed from: a */
    final /* synthetic */ boolean f3800a;
    /* renamed from: b */
    final /* synthetic */ C0517a f3801b;
    /* renamed from: c */
    final /* synthetic */ boolean f3802c;
    /* renamed from: d */
    final /* synthetic */ DkUserPurchasedBooksManager f3803d;

    ca(DkUserPurchasedBooksManager dkUserPurchasedBooksManager, boolean z, C0517a c0517a, boolean z2) {
        this.f3803d = dkUserPurchasedBooksManager;
        this.f3800a = z;
        this.f3801b = c0517a;
        this.f3802c = z2;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        this.f3803d.m5053a(new cb(this));
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f3801b.mo729a(-1, str);
    }
}
