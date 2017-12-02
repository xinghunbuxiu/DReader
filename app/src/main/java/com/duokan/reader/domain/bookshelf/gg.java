package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.ah;

import java.util.Map;

class gg implements Runnable {
    final /* synthetic */ Map a;
    final /* synthetic */ gf b;

    gg(gf gfVar, Map map) {
        this.b = gfVar;
        this.a = map;
    }

    public void run() {
        ej.E.acquireUninterruptibly();
        ah.b(new gh(this));
    }
}
