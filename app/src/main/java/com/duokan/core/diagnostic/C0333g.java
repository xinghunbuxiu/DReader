package com.duokan.core.diagnostic;

import java.util.concurrent.ConcurrentLinkedQueue;


class C0333g implements Runnable {
    
    final  ConcurrentLinkedQueue f569a;
    
    final  HttpLogger f570b;

    C0333g(HttpLogger httpLogger, ConcurrentLinkedQueue concurrentLinkedQueue) {
        this.f570b = httpLogger;
        this.f569a = concurrentLinkedQueue;
    }

    public void run() {
        HttpLogger.m745b(this.f569a, this.f570b.f554c);
    }
}
