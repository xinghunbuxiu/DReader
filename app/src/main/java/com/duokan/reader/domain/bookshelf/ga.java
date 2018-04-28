package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.ah;
import java.util.Map;

class ga implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Map f3216a;
    /* renamed from: b */
    final /* synthetic */ fz f3217b;

    ga(fz fzVar, Map map) {
        this.f3217b = fzVar;
        this.f3216a = map;
    }

    public void run() {
        ee.f3084E.acquireUninterruptibly();
        ah.m871b(new gb(this));
    }
}
