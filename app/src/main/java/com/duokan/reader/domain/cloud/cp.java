package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import java.util.List;

class cp implements C0666x {
    /* renamed from: a */
    final /* synthetic */ String f3825a;
    /* renamed from: b */
    final /* synthetic */ List f3826b;
    /* renamed from: c */
    final /* synthetic */ C0517a f3827c;
    /* renamed from: d */
    final /* synthetic */ DkUserPurchasedFictionsManager f3828d;

    cp(DkUserPurchasedFictionsManager dkUserPurchasedFictionsManager, String str, List list, C0517a c0517a) {
        this.f3828d = dkUserPurchasedFictionsManager;
        this.f3825a = str;
        this.f3826b = list;
        this.f3827c = c0517a;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        this.f3828d.m5094a(new cq(this));
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f3827c.mo729a(-1, str);
    }
}
