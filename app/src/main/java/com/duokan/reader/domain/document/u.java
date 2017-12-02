package com.duokan.reader.domain.document;

import java.util.Iterator;

class u implements Runnable {
    final /* synthetic */ n a;

    u(n nVar) {
        this.a = nVar;
    }

    public void run() {
        if (!this.a.a) {
            Iterator it = this.a.e.iterator();
            while (it.hasNext()) {
                ((w) it.next()).f(this.a);
            }
        }
    }
}
