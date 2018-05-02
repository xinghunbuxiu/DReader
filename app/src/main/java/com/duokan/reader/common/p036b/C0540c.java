package com.duokan.reader.common.p036b;

import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.duokan.reader.common.b.c */
class C0540c implements Runnable {
    /* renamed from: a */
    final /* synthetic */ AtomicInteger f1802a;
    /* renamed from: b */
    final /* synthetic */ boolean f1803b;
    /* renamed from: c */
    final /* synthetic */ Runnable f1804c;
    /* renamed from: d */
    final /* synthetic */ C0538a f1805d;

    C0540c(C0538a c0538a, AtomicInteger atomicInteger, boolean z, Runnable runnable) {
        this.f1805d = c0538a;
        this.f1802a = atomicInteger;
        this.f1803b = z;
        this.f1804c = runnable;
    }

    public void run() {
        if (this.f1802a.decrementAndGet() == 0) {
            if (this.f1803b) {
                this.f1805d.m2407g();
            }
            if (this.f1804c != null) {
                this.f1804c.run();
            }
        }
    }
}
