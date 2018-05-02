package com.duokan.reader.common;

import java.util.Iterator;

class f implements Runnable {
    final /* synthetic */ d a;

    f(d dVar) {
        this.a = dVar;
    }

    public void run() {
        Iterator it = this.a.f.iterator();
        while (it.hasNext()) {
            ((h) it.next()).a(this.a.h);
        }
    }
}
