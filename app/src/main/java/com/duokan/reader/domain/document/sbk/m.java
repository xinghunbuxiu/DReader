package com.duokan.reader.domain.document.sbk;

import com.duokan.reader.domain.document.bc;

import java.util.Iterator;
import java.util.concurrent.Semaphore;

class m extends SbkTypesettingContext {
    final /* synthetic */ f h;
    private c n = null;

    public m(f fVar, s sVar, p pVar, Semaphore semaphore) {
        this.h = fVar;
        super(sVar, pVar, semaphore);
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
}
