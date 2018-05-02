package com.duokan.reader.common.cache;

import java.util.ArrayList;

class o implements Runnable {
    final /* synthetic */ n a;

    o(n nVar) {
        this.a = nVar;
    }

    public void run() {
        if (!this.a.b) {
            this.a.b(new ArrayList(this.a.e));
        }
        synchronized (this.a.g) {
            this.a.e = null;
            this.a.f = null;
            this.a.g.notifyAll();
        }
        if (!this.a.b) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            this.a.d();
        }
    }
}
