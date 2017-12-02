package com.duokan.reader.ui.bookshelf;

import com.duokan.reader.domain.bookshelf.c;

class bw implements Runnable {
    final /* synthetic */ c a;
    final /* synthetic */ bk b;

    bw(bk bkVar, c cVar) {
        this.b = bkVar;
        this.a = cVar;
    }

    public void run() {
        this.b.h.a(this.a);
    }
}
