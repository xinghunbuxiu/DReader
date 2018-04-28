package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;

class by implements C0666x {
    /* renamed from: a */
    final /* synthetic */ boolean f3793a;
    /* renamed from: b */
    final /* synthetic */ boolean f3794b;
    /* renamed from: c */
    final /* synthetic */ C0517a f3795c;
    /* renamed from: d */
    final /* synthetic */ DkUserPurchasedBooksManager f3796d;

    by(DkUserPurchasedBooksManager dkUserPurchasedBooksManager, boolean z, boolean z2, C0517a c0517a) {
        this.f3796d = dkUserPurchasedBooksManager;
        this.f3793a = z;
        this.f3794b = z2;
        this.f3795c = c0517a;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        this.f3796d.m5064b(new bz(this));
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f3795c.mo729a(-1, "");
    }
}
