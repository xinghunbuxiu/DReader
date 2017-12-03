package com.duokan.reader.domain.document.txt;

import com.duokan.core.sys.TaskHandler;

import java.util.concurrent.TimeUnit;

class k implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ f c;

    k(f fVar, Runnable runnable, Runnable runnable2) {
        this.c = fVar;
        this.a = runnable;
        this.b = runnable2;
    }

    public void run() {
        while (!this.c.p && !this.c.j.d() && this.c.d.a && !this.c.d.c()) {
            try {
                this.c.q.await(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
            }
        }
        TaskHandler.postTask(new l(this));
    }
}
