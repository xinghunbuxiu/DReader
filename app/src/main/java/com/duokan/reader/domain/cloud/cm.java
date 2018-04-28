package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;

class cm implements C0666x {
    /* renamed from: a */
    final /* synthetic */ String f3818a;
    /* renamed from: b */
    final /* synthetic */ C0517a f3819b;
    /* renamed from: c */
    final /* synthetic */ DkUserPurchasedFictionsManager f3820c;

    cm(DkUserPurchasedFictionsManager dkUserPurchasedFictionsManager, String str, C0517a c0517a) {
        this.f3820c = dkUserPurchasedFictionsManager;
        this.f3818a = str;
        this.f3819b = c0517a;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        this.f3820c.m5094a(new cn(this));
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f3819b.mo729a(-1, str);
    }
}
