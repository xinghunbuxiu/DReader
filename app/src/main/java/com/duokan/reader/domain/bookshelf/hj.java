package com.duokan.reader.domain.bookshelf;

import java.util.Iterator;

class hj implements Runnable {
    final /* synthetic */ hi a;

    hj(hi hiVar) {
        this.a = hiVar;
    }

    public void run() {
        Iterator it = this.a.r.iterator();
        while (it.hasNext()) {
            ((iw) it.next()).onItemsChanged();
        }
    }
}
