package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;

class be implements C0666x {
    /* renamed from: a */
    final /* synthetic */ String[] f3744a;
    /* renamed from: b */
    final /* synthetic */ C0517a f3745b;
    /* renamed from: c */
    final /* synthetic */ DkUserPurchasedBooksManager f3746c;

    be(DkUserPurchasedBooksManager dkUserPurchasedBooksManager, String[] strArr, C0517a c0517a) {
        this.f3746c = dkUserPurchasedBooksManager;
        this.f3744a = strArr;
        this.f3745b = c0517a;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        this.f3746c.m5053a(new bf(this));
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f3745b.mo729a(-1, str);
    }
}
