package com.duokan.reader.domain.document.txt;

import com.duokan.core.sys.TaskHandler;

class ak implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ aj c;

    ak(aj ajVar, Runnable runnable, Runnable runnable2) {
        this.c = ajVar;
        this.a = runnable;
        this.b = runnable2;
    }

    public void run() {
        while (!this.c.j && !this.c.i.d() && this.c.d.a && !this.c.d.c()) {
            try {
                Thread.sleep(50);
            } catch (Throwable th) {
            }
        }
        TaskHandler.postTask(new al(this));
    }
}
