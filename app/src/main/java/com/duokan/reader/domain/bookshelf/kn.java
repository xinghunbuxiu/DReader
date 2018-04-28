package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.ah;

class kn implements Runnable {
    /* renamed from: a */
    final /* synthetic */ kz f3469a;
    /* renamed from: b */
    final /* synthetic */ boolean f3470b;
    /* renamed from: c */
    final /* synthetic */ kh f3471c;

    kn(kh khVar, kz kzVar, boolean z) {
        this.f3471c = khVar;
        this.f3469a = kzVar;
        this.f3470b = z;
    }

    public void run() {
        ee.f3084E.acquireUninterruptibly();
        ah.m871b(new ko(this));
    }
}
