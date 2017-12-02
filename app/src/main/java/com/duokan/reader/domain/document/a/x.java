package com.duokan.reader.domain.document.a;

import com.duokan.core.sys.t;

class x implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ w c;

    x(w wVar, Runnable runnable, Runnable runnable2) {
        this.c = wVar;
        this.a = runnable;
        this.b = runnable2;
    }

    public void run() {
        while (!this.c.j && !this.c.i.c() && this.c.d.a && !this.c.d.c()) {
            try {
                Thread.sleep(50);
            } catch (Throwable th) {
            }
        }
        t.a(new y(this));
    }
}
