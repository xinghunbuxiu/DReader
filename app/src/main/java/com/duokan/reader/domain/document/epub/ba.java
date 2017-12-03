package com.duokan.reader.domain.document.epub;

import com.duokan.core.sys.TaskHandler;

class ba implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ az c;

    ba(az azVar, Runnable runnable, Runnable runnable2) {
        this.c = azVar;
        this.a = runnable;
        this.b = runnable2;
    }

    public void run() {
        while (!this.c.m && !this.c.j.d() && this.c.e.a && !this.c.e.c()) {
            try {
                Thread.sleep(50);
            } catch (Throwable th) {
            }
        }
        TaskHandler.postTask(new bb(this));
    }
}
