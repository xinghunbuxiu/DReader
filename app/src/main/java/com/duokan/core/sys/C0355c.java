package com.duokan.core.sys;

import java.util.ListIterator;
import java.util.concurrent.Semaphore;

/* renamed from: com.duokan.core.sys.c */
class C0355c implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Semaphore f708a;
    /* renamed from: b */
    final /* synthetic */ AsyncCache f709b;

    C0355c(AsyncCache asyncCache, Semaphore semaphore) {
        this.f709b = asyncCache;
        this.f708a = semaphore;
    }

    public void run() {
        synchronized (this.f709b.m811c()) {
            ListIterator a = this.f709b.m807b(false);
            while (a.hasNext()) {
                C0359g c0359g = (C0359g) a.next();
                if (c0359g.f726b.mo771i() > 0 && !c0359g.f726b.m1011d()) {
                    this.f709b.f588g = this.f709b.f588g - c0359g.f726b.mo771i();
                    c0359g.f726b.m1002o();
                }
            }
        }
        this.f708a.release();
    }
}
