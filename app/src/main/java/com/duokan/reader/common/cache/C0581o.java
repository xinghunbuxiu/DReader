package com.duokan.reader.common.cache;

import java.util.ArrayList;

/* renamed from: com.duokan.reader.common.cache.o */
class C0581o implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0580n f1899a;

    C0581o(C0580n c0580n) {
        this.f1899a = c0580n;
    }

    public void run() {
        if (!this.f1899a.f1890b) {
            this.f1899a.m2601b(new ArrayList(this.f1899a.f1893e));
        }
        synchronized (this.f1899a.f1895g) {
            this.f1899a.f1893e = null;
            this.f1899a.f1894f = null;
            this.f1899a.f1895g.notifyAll();
        }
        if (!this.f1899a.f1890b) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            this.f1899a.m2603d();
        }
    }
}
