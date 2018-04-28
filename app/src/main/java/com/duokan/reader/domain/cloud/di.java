package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;

class di implements C0666x {
    /* renamed from: a */
    final /* synthetic */ String[] f3877a;
    /* renamed from: b */
    final /* synthetic */ C0517a f3878b;
    /* renamed from: c */
    final /* synthetic */ DkUserPurchasedFictionsManager f3879c;

    di(DkUserPurchasedFictionsManager dkUserPurchasedFictionsManager, String[] strArr, C0517a c0517a) {
        this.f3879c = dkUserPurchasedFictionsManager;
        this.f3877a = strArr;
        this.f3878b = c0517a;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        this.f3879c.m5094a(new dj(this));
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f3878b.mo729a(-1, str);
    }
}
