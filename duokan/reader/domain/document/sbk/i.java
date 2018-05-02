package com.duokan.reader.domain.document.sbk;

import com.duokan.reader.domain.document.w;

import java.util.Iterator;

class i implements Runnable {
    static final /* synthetic */ boolean a = (!f.class.desiredAssertionStatus());
    final /* synthetic */ c b;
    final /* synthetic */ f c;

    i(f fVar, c cVar) {
        this.c = fVar;
        this.b = cVar;
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
