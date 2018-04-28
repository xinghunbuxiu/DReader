package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.duokan.C0629b;
import com.duokan.reader.common.webservices.duokan.DkStoreBookPrice;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.payment.C1085q;
import com.duokan.reader.ui.store.bj;

class fd implements bj {
    /* renamed from: a */
    final /* synthetic */ String f3985a;
    /* renamed from: b */
    final /* synthetic */ C0672a f3986b;
    /* renamed from: c */
    final /* synthetic */ DkStoreBookPrice f3987c;
    /* renamed from: d */
    final /* synthetic */ fc f3988d;

    fd(fc fcVar, String str, C0672a c0672a, DkStoreBookPrice dkStoreBookPrice) {
        this.f3988d = fcVar;
        this.f3985a = str;
        this.f3986b = c0672a;
        this.f3987c = dkStoreBookPrice;
    }

    /* renamed from: a */
    public void mo1162a(C1085q c1085q) {
        new fe(this, this.f3985a, C0629b.f2117a, c1085q.mo1499a()).open();
    }
}
