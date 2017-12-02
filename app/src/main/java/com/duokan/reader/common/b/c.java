package com.duokan.reader.common.b;

import java.util.concurrent.atomic.AtomicInteger;

class c implements Runnable {
    final /* synthetic */ AtomicInteger a;
    final /* synthetic */ boolean b;
    final /* synthetic */ Runnable c;
    final /* synthetic */ a d;

    c(a aVar, AtomicInteger atomicInteger, boolean z, Runnable runnable) {
        this.d = aVar;
        this.a = atomicInteger;
        this.b = z;
        this.c = runnable;
    }

    public void run() {
        if (this.a.decrementAndGet() == 0) {
            if (this.b) {
                this.d.g();
            }
            if (this.c != null) {
                this.c.run();
            }
        }
    }
}
