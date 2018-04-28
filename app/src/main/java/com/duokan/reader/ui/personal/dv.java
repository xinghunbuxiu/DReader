package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.micloud.C1068i;

class dv implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1068i f8470a;
    /* renamed from: b */
    final /* synthetic */ dr f8471b;

    dv(dr drVar, C1068i c1068i) {
        this.f8471b = drVar;
        this.f8470a = c1068i;
    }

    public void run() {
        if (this.f8471b.f8465a.f8457b != null) {
            this.f8471b.f8465a.f8457b.m11751a(this.f8470a, false);
        }
    }
}
