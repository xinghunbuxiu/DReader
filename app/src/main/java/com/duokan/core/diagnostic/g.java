package com.duokan.core.diagnostic;

import java.util.concurrent.ConcurrentLinkedQueue;

class g implements Runnable {
    final /* synthetic */ ConcurrentLinkedQueue a;
    final /* synthetic */ f b;

    g(f fVar, ConcurrentLinkedQueue concurrentLinkedQueue) {
        this.b = fVar;
        this.a = concurrentLinkedQueue;
    }

    public void run() {
        f.b(this.a, this.b.c);
    }
}
