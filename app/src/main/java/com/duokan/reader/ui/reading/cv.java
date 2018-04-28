package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.document.as;

class cv implements Runnable {
    /* renamed from: a */
    final /* synthetic */ cq f9965a;

    cv(cq cqVar) {
        this.f9965a = cqVar;
    }

    public void run() {
        as aa = this.f9965a.f9949a.aa();
        int f = this.f9965a.f9955g - aa.mo1352v(0);
        this.f9965a.f9950b.m10019g();
        this.f9965a.f9952d.m13309a(aa.mo1350u(f), new cw(this));
    }
}
