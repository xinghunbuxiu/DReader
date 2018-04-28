package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;

class cs implements C0666x {
    /* renamed from: a */
    final /* synthetic */ String f3833a;
    /* renamed from: b */
    final /* synthetic */ C0517a f3834b;
    /* renamed from: c */
    final /* synthetic */ DkUserPurchasedFictionsManager f3835c;

    cs(DkUserPurchasedFictionsManager dkUserPurchasedFictionsManager, String str, C0517a c0517a) {
        this.f3835c = dkUserPurchasedFictionsManager;
        this.f3833a = str;
        this.f3834b = c0517a;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        this.f3835c.m5094a(new ct(this));
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f3834b.mo729a(-1, str);
    }
}
