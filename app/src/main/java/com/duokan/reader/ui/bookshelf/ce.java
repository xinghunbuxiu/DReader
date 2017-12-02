package com.duokan.reader.ui.bookshelf;

import com.duokan.reader.domain.bookshelf.an;

class ce implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ an b;
    final /* synthetic */ bz c;

    ce(bz bzVar, boolean z, an anVar) {
        this.c = bzVar;
        this.a = z;
        this.b = anVar;
    }

    public void run() {
        if (!this.a) {
            this.c.a.b(this.b);
        }
        this.c.f(false);
    }
}
