package com.duokan.reader.ui.bookshelf;

import com.duokan.reader.ui.surfing.af;

class bv implements Runnable {
    final /* synthetic */ af a;
    final /* synthetic */ bk b;

    bv(bk bkVar, af afVar) {
        this.b = bkVar;
        this.a = afVar;
    }

    public void run() {
        this.b.removeSubController(this.b.i);
        this.b.i = null;
        this.b.h = null;
        this.a.p();
        if (this.b.j != null) {
            this.b.j.b();
        }
        if (this.b.n != null) {
            this.b.n.run();
            this.b.n = null;
        }
    }
}
