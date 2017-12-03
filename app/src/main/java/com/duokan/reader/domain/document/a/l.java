package com.duokan.reader.domain.document.a;

import com.duokan.reader.domain.document.bc;

import java.util.Iterator;
import java.util.concurrent.Semaphore;

class l extends ah {
    final /* synthetic */ d h;
    private b n = null;

    public l(d dVar, r rVar, q qVar, Semaphore semaphore) {
        this.h = dVar;
        super(rVar, qVar, semaphore);
    }

    public boolean c() {
        if (this.b) {
            return false;
        }
        synchronized (this.h) {
            if (this.a) {
                Object a = j.a();
                Iterator it = this.h.l.iterator();
                while (it.hasNext()) {
                    bc bcVar = (bc) it.next();
                    if (bcVar == this) {
                        return false;
                    } else if (bcVar.a(a)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
    }

    public b e() {
        return this.n;
    }

    public int a(v vVar) {
        if (!this.e.c()) {
            return this.e.a;
        }
        return this.h.k.h().getPageWidth(p.a(this.h.k.h(), (s) vVar));
    }

    public int b(v vVar) {
        if (!this.e.c()) {
            return this.e.b;
        }
        return this.h.k.h().getPageHeight(p.a(this.h.k.h(), (s) vVar));
    }
}
