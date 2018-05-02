package com.duokan.reader.domain.document;

import java.util.Iterator;

class r implements Runnable {
    static final /* synthetic */ boolean a = (!n.class.desiredAssertionStatus());
    final /* synthetic */ as b;
    final /* synthetic */ n c;

    r(n nVar, as asVar) {
        this.c = nVar;
        this.b = asVar;
    }

    public void run() {
        if (!this.c.a && !this.b.F()) {
            Iterator it = this.c.f.iterator();
            while (it.hasNext()) {
                at atVar = (at) it.next();
                if (a || atVar != null) {
                    atVar.a(this.c, this.b);
                } else {
                    throw new AssertionError();
                }
            }
        }
    }
}
