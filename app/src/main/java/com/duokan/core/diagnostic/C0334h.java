package com.duokan.core.diagnostic;

import java.util.concurrent.ConcurrentLinkedQueue;


class C0334h implements Runnable {
    
    final  ConcurrentLinkedQueue f571a;
    
    final  HttpLogger f572b;

    C0334h(HttpLogger httpLogger, ConcurrentLinkedQueue concurrentLinkedQueue) {
        this.f572b = httpLogger;
        this.f571a = concurrentLinkedQueue;
    }

    public void run() {
        HttpLogger.m745b(this.f571a, this.f572b.f554c);
    }
}
