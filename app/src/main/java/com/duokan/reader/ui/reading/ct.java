package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.document.C0932e;
import com.duokan.reader.domain.document.as;

class ct implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0932e f9961a;
    /* renamed from: b */
    final /* synthetic */ int f9962b;
    /* renamed from: c */
    final /* synthetic */ cq f9963c;

    ct(cq cqVar, C0932e c0932e, int i) {
        this.f9963c = cqVar;
        this.f9961a = c0932e;
        this.f9962b = i;
    }

    public void run() {
        as aa = this.f9963c.f9949a.aa();
        aa.mo1282E();
        if (!aa.mo1332l().m5812a(this.f9961a.mo1429a())) {
            this.f9963c.f9949a.mo2024a(this.f9961a.mo1429a());
            aa = this.f9963c.f9949a.aa();
        }
        this.f9963c.f9952d.m13310a(this.f9963c.f9953e.mo2303a(this.f9962b), aa.mo1350u(this.f9962b - aa.mo1352v(0)), new cu(this));
    }
}
