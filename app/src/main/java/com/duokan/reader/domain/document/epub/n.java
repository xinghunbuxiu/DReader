package com.duokan.reader.domain.document.epub;

import com.duokan.core.sys.t;

import java.util.concurrent.TimeUnit;

class n implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ i c;

    n(i iVar, Runnable runnable, Runnable runnable2) {
        this.c = iVar;
        this.a = runnable;
        this.b = runnable2;
    }

    public void run() {
        while (!this.c.r && !this.c.j.d() && this.c.d.a && !this.c.d.c()) {
            try {
                this.c.t.await(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
            }
        }
        t.a(new o(this));
    }
}
