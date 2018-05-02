package com.duokan.reader.domain.document;

import java.util.Iterator;

class t implements Runnable {
    final /* synthetic */ n a;

    t(n nVar) {
        this.a = nVar;
    }

    public void run() {
        if (!this.a.a) {
            Iterator it = this.a.e.iterator();
            while (it.hasNext()) {
                ((w) it.next()).e(this.a);
            }
        }
    }
}
