package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.ag;

class el implements Runnable {
    final /* synthetic */ ag a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ ej c;

    el(ej ejVar, ag agVar, Runnable runnable) {
        this.c = ejVar;
        this.a = agVar;
        this.b = runnable;
    }

    public void run() {
        this.c.aT().e().a(this.c.H(), false, false, -1, -1, -1, new em(this));
    }
}
