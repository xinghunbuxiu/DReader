package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.i;

class bw implements Runnable {
    final /* synthetic */ bv a;

    bw(bv bvVar) {
        this.a = bvVar;
    }

    public void run() {
        this.a.c();
        i.f().a(new bx(this));
    }
}
