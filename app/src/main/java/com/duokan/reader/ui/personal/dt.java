package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.micloud.C1068i;

class dt implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1068i f8467a;
    /* renamed from: b */
    final /* synthetic */ dr f8468b;

    dt(dr drVar, C1068i c1068i) {
        this.f8468b = drVar;
        this.f8467a = c1068i;
    }

    public void run() {
        if (this.f8468b.f8465a.f8457b != null) {
            this.f8468b.f8465a.f8457b.m11751a(this.f8467a, false);
        }
    }
}
