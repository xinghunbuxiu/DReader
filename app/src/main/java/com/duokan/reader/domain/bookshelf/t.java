package com.duokan.reader.domain.bookshelf;

import java.util.Iterator;

class t implements Runnable {
    final /* synthetic */ c a;

    t(c cVar) {
        this.a = cVar;
    }

    public void run() {
        if (this.a.linkedList != null) {
            Iterator it = this.a.linkedList.iterator();
            while (it.hasNext()) {
                ((w) it.next()).a(this.a.aq());
            }
        }
    }
}
