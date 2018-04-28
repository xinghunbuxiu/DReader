package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.duokan.C0643q;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.al;

class as implements C0666x {
    /* renamed from: a */
    final /* synthetic */ int f3704a;
    /* renamed from: b */
    final /* synthetic */ int f3705b;
    /* renamed from: c */
    final /* synthetic */ boolean f3706c;
    /* renamed from: d */
    final /* synthetic */ ap f3707d;

    as(ap apVar, int i, int i2, boolean z) {
        this.f3707d = apVar;
        this.f3704a = i;
        this.f3705b = i2;
        this.f3706c = z;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        this.f3707d.f3700f = new al(c0672a);
        new at(this, this.f3707d.f3700f.f2360a, C0643q.f2173a, this.f3707d.f3700f).open();
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
    }
}
