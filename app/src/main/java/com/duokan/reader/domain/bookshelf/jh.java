package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.c.f;

class jh implements Runnable {
    final /* synthetic */ iz a;

    jh(iz izVar) {
        this.a = izVar;
    }

    public void run() {
        this.a.h();
        this.a.a(f.b());
        f.b().a(this.a.c);
    }
}
