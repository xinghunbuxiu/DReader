package com.duokan.reader.domain.document.sbk;

import com.duokan.core.sys.TaskHandler;

class z implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ y c;

    z(y yVar, Runnable runnable, Runnable runnable2) {
        this.c = yVar;
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
        TaskHandler.postTask(new aa(this));
    }
}
