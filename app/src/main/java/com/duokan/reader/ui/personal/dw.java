package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.micloud.C1068i;

class dw implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1068i f8472a;
    /* renamed from: b */
    final /* synthetic */ dr f8473b;

    dw(dr drVar, C1068i c1068i) {
        this.f8473b = drVar;
        this.f8472a = c1068i;
    }

    public void run() {
        if (this.f8473b.f8465a.f8457b != null) {
            this.f8473b.f8465a.f8457b.m11751a(this.f8472a, false);
        }
    }
}
