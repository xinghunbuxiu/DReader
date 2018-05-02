package com.duokan.reader.domain.document;

import java.util.Iterator;

class v implements Runnable {
    static final /* synthetic */ boolean a = (!n.class.desiredAssertionStatus());
    final /* synthetic */ aa b;
    final /* synthetic */ n c;

    v(n nVar, aa aaVar) {
        this.c = nVar;
        this.b = aaVar;
    }

    public void run() {
        if (!this.c.a) {
            Iterator it = this.c.e.iterator();
            while (it.hasNext()) {
                w wVar = (w) it.next();
                if (a || wVar != null) {
                    wVar.a(this.c, this.b);
                } else {
                    throw new AssertionError();
                }
            }
        }
    }
}
