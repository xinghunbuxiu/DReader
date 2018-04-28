package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.micloud.C1068i;

class iv implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1068i f3367a;
    /* renamed from: b */
    final /* synthetic */ it f3368b;

    iv(it itVar, C1068i c1068i) {
        this.f3368b = itVar;
        this.f3367a = c1068i;
    }

    public void run() {
        jp b = this.f3368b.f3365i;
        if (b != null) {
            b.f3405b.m8112a().m2370d(this.f3367a);
        }
    }
}
