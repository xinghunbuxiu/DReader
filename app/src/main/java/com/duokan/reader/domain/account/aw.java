package com.duokan.reader.domain.account;

import com.duokan.reader.common.p036b.C0538a;

class aw implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0538a f2390a;
    /* renamed from: b */
    final /* synthetic */ MiAccount f2391b;

    aw(MiAccount miAccount, C0538a c0538a) {
        this.f2391b = miAccount;
        this.f2390a = c0538a;
    }

    public void run() {
        this.f2390a.m2404d();
    }
}
