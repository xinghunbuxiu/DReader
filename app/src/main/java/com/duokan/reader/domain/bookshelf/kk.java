package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.ah;
import java.util.Map;

class kk implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Map f3465a;
    /* renamed from: b */
    final /* synthetic */ kj f3466b;

    kk(kj kjVar, Map map) {
        this.f3466b = kjVar;
        this.f3465a = map;
    }

    public void run() {
        ee.f3084E.acquireUninterruptibly();
        ah.m871b(new kl(this));
    }
}
