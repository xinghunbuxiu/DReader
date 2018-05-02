package com.duokan.reader.domain.document.a;

import com.duokan.reader.domain.document.w;

import java.util.Iterator;

class g implements Runnable {
    static final /* synthetic */ boolean a = (!d.class.desiredAssertionStatus());
    final /* synthetic */ b b;
    final /* synthetic */ d c;

    g(d dVar, b bVar) {
        this.c = dVar;
        this.b = bVar;
    }

    public void run() {
        if (!this.c.a) {
            Iterator it = this.c.e.iterator();
            while (it.hasNext()) {
                w wVar = (w) it.next();
                if (a || wVar != null) {
                    wVar.d(this.c);
                } else {
                    throw new AssertionError();
                }
            }
        }
        this.b.g();
    }
}
