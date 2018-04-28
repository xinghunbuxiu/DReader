package com.duokan.reader.domain.bookshelf;

import java.util.Iterator;

class hd implements Runnable {
    /* renamed from: a */
    final /* synthetic */ hc f3297a;

    hd(hc hcVar) {
        this.f3297a = hcVar;
    }

    public void run() {
        Iterator it = this.f3297a.f2753r.iterator();
        while (it.hasNext()) {
            ((iq) it.next()).onItemsChanged();
        }
    }
}
