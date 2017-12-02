package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.a;

class gj implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ fv c;

    gj(fv fvVar, a aVar, Runnable runnable) {
        this.c = fvVar;
        this.a = aVar;
        this.b = runnable;
    }

    public void run() {
        new gk(this).open();
    }
}
