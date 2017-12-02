package com.duokan.reader.domain.document.epub;

import java.util.Iterator;

class w implements Runnable {
    static final /* synthetic */ boolean a = (!s.class.desiredAssertionStatus());
    final /* synthetic */ e b;
    final /* synthetic */ s c;

    w(s sVar, e eVar) {
        this.c = sVar;
        this.b = eVar;
    }

    public void run() {
        if (!this.c.a) {
            Iterator it = this.c.e.iterator();
            while (it.hasNext()) {
                com.duokan.reader.domain.document.w wVar = (com.duokan.reader.domain.document.w) it.next();
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
