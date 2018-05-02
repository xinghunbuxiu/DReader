package com.duokan.reader.domain.document;

import java.util.Iterator;

class o implements Runnable {
    static final /* synthetic */ boolean a = (!n.class.desiredAssertionStatus());
    final /* synthetic */ n b;

    o(n nVar) {
        this.b = nVar;
    }

    public void run() {
        Iterator it = this.b.e.iterator();
        while (it.hasNext()) {
            w wVar = (w) it.next();
            if (a || wVar != null) {
                wVar.a(this.b);
            } else {
                throw new AssertionError();
            }
        }
        if (this.b.a) {
            this.b.t();
        } else {
            this.b.c = true;
        }
    }
}
