package com.duokan.reader.domain.bookshelf;

import java.util.Iterator;

class ia implements Runnable {
    final /* synthetic */ c a;
    final /* synthetic */ hi b;

    ia(hi hiVar, c cVar) {
        this.b = hiVar;
        this.a = cVar;
    }

    public void run() {
        Iterator it = this.b.s.iterator();
        while (it.hasNext()) {
            ((it) it.next()).a(this.a);
        }
    }
}
