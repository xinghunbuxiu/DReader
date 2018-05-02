package com.duokan.reader.domain.bookshelf;

import java.util.Iterator;

class hx implements Runnable {
    final /* synthetic */ an a;
    final /* synthetic */ int b;
    final /* synthetic */ hv c;

    hx(hv hvVar, an anVar, int i) {
        this.c = hvVar;
        this.a = anVar;
        this.b = i;
    }

    public void run() {
        Iterator it = this.c.b.q.iterator();
        while (it.hasNext()) {
            ((iv) it.next()).onItemChanged(this.a, this.b);
        }
    }
}
