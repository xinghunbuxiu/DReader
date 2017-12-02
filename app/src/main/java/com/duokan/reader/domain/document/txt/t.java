package com.duokan.reader.domain.document.txt;

import com.duokan.reader.domain.document.w;

import java.util.Iterator;

class t implements Runnable {
    static final /* synthetic */ boolean a = (!p.class.desiredAssertionStatus());
    final /* synthetic */ c b;
    final /* synthetic */ p c;

    t(p pVar, c cVar) {
        this.c = pVar;
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
