package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.ah;

import java.util.Map;

class jy implements Runnable {
    final /* synthetic */ Map a;
    final /* synthetic */ jx b;

    jy(jx jxVar, Map map) {
        this.b = jxVar;
        this.a = map;
    }

    public void run() {
        ej.E.acquireUninterruptibly();
        ah.b(new jz(this));
    }
}
