package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.ag;

import java.util.Iterator;

class ez implements Runnable {
    final /* synthetic */ fb a;
    final /* synthetic */ ej b;

    ez(ej ejVar, fb fbVar) {
        this.b = ejVar;
        this.a = fbVar;
    }

    public void run() {
        Iterator it = this.a.f.iterator();
        while (it.hasNext()) {
            ((ag) it.next()).a(Integer.valueOf(this.a.h));
        }
    }
}
