package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;

class bh implements C0666x {
    /* renamed from: a */
    final /* synthetic */ String f3752a;
    /* renamed from: b */
    final /* synthetic */ C0517a f3753b;
    /* renamed from: c */
    final /* synthetic */ DkUserPurchasedBooksManager f3754c;

    bh(DkUserPurchasedBooksManager dkUserPurchasedBooksManager, String str, C0517a c0517a) {
        this.f3754c = dkUserPurchasedBooksManager;
        this.f3752a = str;
        this.f3753b = c0517a;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        this.f3754c.m5053a(new bi(this));
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f3753b.mo729a(-1, str);
    }
}
