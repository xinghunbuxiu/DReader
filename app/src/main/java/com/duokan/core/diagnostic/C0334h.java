package com.duokan.core.diagnostic;

import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.duokan.core.diagnostic.h */
class C0334h implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ConcurrentLinkedQueue f571a;
    /* renamed from: b */
    final /* synthetic */ HttpLogger f572b;

    C0334h(HttpLogger httpLogger, ConcurrentLinkedQueue concurrentLinkedQueue) {
        this.f572b = httpLogger;
        this.f571a = concurrentLinkedQueue;
    }

    public void run() {
        HttpLogger.m745b(this.f571a, this.f572b.f554c);
    }
}
