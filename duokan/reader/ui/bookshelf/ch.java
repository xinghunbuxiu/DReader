package com.duokan.reader.ui.bookshelf;

import com.duokan.reader.domain.bookshelf.an;

class ch implements Runnable {
    final /* synthetic */ an a;
    final /* synthetic */ an b;
    final /* synthetic */ int c;
    final /* synthetic */ bz d;

    ch(bz bzVar, an anVar, an anVar2, int i) {
        this.d = bzVar;
        this.a = anVar;
        this.b = anVar2;
        this.c = i;
    }

    public void run() {
        this.d.a(500, new ci(this));
    }
}
