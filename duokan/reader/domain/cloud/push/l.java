package com.duokan.reader.domain.cloud.push;

import java.util.Iterator;

class l implements Runnable {
    final /* synthetic */ b a;

    l(b bVar) {
        this.a = bVar;
    }

    public void run() {
        Iterator it = this.a.h.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a();
        }
    }
}
