package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.h;

class bx implements h {
    final /* synthetic */ bw a;

    bx(bw bwVar) {
        this.a = bwVar;
    }

    public void a(a aVar) {
        this.a.a.c = new ab(aVar);
        this.a.a.c();
    }

    public void b(a aVar) {
    }

    public void c(a aVar) {
        if (this.a.a.c.c()) {
            new by(this, this.a.a.c).open();
        }
        this.a.a.c = ab.g;
        this.a.a.e = true;
        this.a.a.f = System.currentTimeMillis();
        this.a.a.d = new cs();
    }

    public void d(a aVar) {
    }
}
