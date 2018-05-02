package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.micloud.o;

class je implements Runnable {
    final /* synthetic */ o a;
    final /* synthetic */ jj b;
    final /* synthetic */ ja c;

    je(ja jaVar, o oVar, jj jjVar) {
        this.c = jaVar;
        this.a = oVar;
        this.b = jjVar;
    }

    public void run() {
        synchronized (this.c.a) {
            if (b.a(this.a.j(), this.c.a.i)) {
                this.c.a.k = this.b;
                this.c.a.l = true;
            }
        }
    }
}
