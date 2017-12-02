package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.micloud.bj;
import com.duokan.reader.domain.micloud.o;

class jd implements Runnable {
    final /* synthetic */ o a;
    final /* synthetic */ bj b;
    final /* synthetic */ ja c;

    jd(ja jaVar, o oVar, bj bjVar) {
        this.c = jaVar;
        this.a = oVar;
        this.b = bjVar;
    }

    public void run() {
        synchronized (this.c.a) {
            if (b.a(this.a.j(), this.c.a.i)) {
                this.c.a.k.a = this.b;
            }
        }
    }
}
