package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.micloud.C1068i;

class ix implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1068i f3371a;
    /* renamed from: b */
    final /* synthetic */ it f3372b;

    ix(it itVar, C1068i c1068i) {
        this.f3372b = itVar;
        this.f3371a = c1068i;
    }

    public void run() {
        jp b = this.f3372b.f3365i;
        if (b != null) {
            b.f3405b.m8112a().m2360a(this.f3371a, true);
        }
    }
}
