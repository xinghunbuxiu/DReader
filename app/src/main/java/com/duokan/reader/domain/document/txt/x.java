package com.duokan.reader.domain.document.txt;

import com.duokan.reader.domain.document.bc;

import java.util.Iterator;
import java.util.concurrent.Semaphore;

class x extends au {
    final /* synthetic */ p h;
    private c n = null;

    public x(p pVar, ae aeVar, ad adVar, Semaphore semaphore) {
        this.h = pVar;
        super(aeVar, adVar, semaphore);
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

    public c e() {
        return this.n;
    }

    public long f() {
        return this.n.b();
    }
}
