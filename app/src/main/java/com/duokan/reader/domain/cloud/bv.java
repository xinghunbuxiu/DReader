package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;

class bv implements C0666x {
    /* renamed from: a */
    final /* synthetic */ String f3786a;
    /* renamed from: b */
    final /* synthetic */ C0517a f3787b;
    /* renamed from: c */
    final /* synthetic */ DkUserPurchasedBooksManager f3788c;

    bv(DkUserPurchasedBooksManager dkUserPurchasedBooksManager, String str, C0517a c0517a) {
        this.f3788c = dkUserPurchasedBooksManager;
        this.f3786a = str;
        this.f3787b = c0517a;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        this.f3788c.m5053a(new bw(this));
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f3787b.mo729a(-1, "");
    }
}
