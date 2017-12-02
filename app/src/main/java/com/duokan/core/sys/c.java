package com.duokan.core.sys;

import java.util.ListIterator;
import java.util.concurrent.Semaphore;

class c implements Runnable {
    final /* synthetic */ Semaphore a;
    final /* synthetic */ AsyncCache b;

    c(AsyncCache asyncCache, Semaphore semaphore) {
        this.b = asyncCache;
        this.a = semaphore;
    }

    public void run() {
        synchronized (this.b.c()) {
            ListIterator a = this.b.b(false);
            while (a.hasNext()) {
                g gVar = (g) a.next();
                if (gVar.b.i() > 0 && !gVar.b.d()) {
                    this.b.g = this.b.g - gVar.b.i();
                    gVar.b.o();
                }
            }
        }
        this.a.release();
    }
}
