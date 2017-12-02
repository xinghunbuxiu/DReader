package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.ah;

class kb implements Runnable {
    final /* synthetic */ kn a;
    final /* synthetic */ boolean b;
    final /* synthetic */ jv c;

    kb(jv jvVar, kn knVar, boolean z) {
        this.c = jvVar;
        this.a = knVar;
        this.b = z;
    }

    public void run() {
        ej.E.acquireUninterruptibly();
        ah.b(new kc(this));
    }
}
