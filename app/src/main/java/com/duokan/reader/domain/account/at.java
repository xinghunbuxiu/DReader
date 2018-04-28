package com.duokan.reader.domain.account;

import com.duokan.reader.DkApp;
import com.duokan.reader.common.p036b.C0538a;

class at implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0699c f2374a;
    /* renamed from: b */
    final /* synthetic */ MiAccount f2375b;

    at(MiAccount miAccount, C0699c c0699c) {
        this.f2375b = miAccount;
        this.f2374a = c0699c;
    }

    public void run() {
        C0538a.m2388a(DkApp.get()).m2404d();
        this.f2374a.mo867a(this.f2375b);
        this.f2375b.a.mo880b(this.f2375b);
        this.f2375b.m3191x();
    }
}
