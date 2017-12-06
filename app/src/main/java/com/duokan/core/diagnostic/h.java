package com.duokan.core.diagnostic;

import java.util.concurrent.ConcurrentLinkedQueue;

class h implements Runnable {
    final ConcurrentLinkedQueue a;
    final HttpLogger b;

    h(HttpLogger fVar, ConcurrentLinkedQueue concurrentLinkedQueue) {
        this.b = fVar;
        this.a = concurrentLinkedQueue;
    }

    public void run() {
        HttpLogger.b(this.a, this.b.c);
    }
}
