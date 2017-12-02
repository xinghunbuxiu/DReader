package com.duokan.reader.domain.document;

import java.util.Iterator;

class p implements Runnable {
    static final /* synthetic */ boolean a = (!n.class.desiredAssertionStatus());
    final /* synthetic */ n b;

    p(n nVar) {
        this.b = nVar;
    }

    public void run() {
        Iterator it = this.b.e.iterator();
        while (it.hasNext()) {
            w wVar = (w) it.next();
            if (a || wVar != null) {
                wVar.b(this.b);
            } else {
                throw new AssertionError();
            }
        }
    }
}
