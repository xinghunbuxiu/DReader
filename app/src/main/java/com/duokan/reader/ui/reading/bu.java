package com.duokan.reader.ui.reading;

import com.duokan.reader.common.webservices.duokan.C0643q;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;

class bu implements C0666x {
    /* renamed from: a */
    final /* synthetic */ String f9900a;
    /* renamed from: b */
    final /* synthetic */ String f9901b;
    /* renamed from: c */
    final /* synthetic */ bn f9902c;

    bu(bn bnVar, String str, String str2) {
        this.f9902c = bnVar;
        this.f9900a = str;
        this.f9901b = str2;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        new bv(this, C0643q.f2173a, c0672a).open();
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
    }
}
