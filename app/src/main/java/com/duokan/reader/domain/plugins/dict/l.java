package com.duokan.reader.domain.plugins.dict;

import com.duokan.core.sys.TaskHandler;
import com.kingsoft.iciba.sdk2.KSCibaEngine;

class l implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ j b;

    l(j jVar, Runnable runnable) {
        this.b = jVar;
        this.a = runnable;
    }

    public void run() {
        try {
            if (this.b.d == null) {
                this.b.d = new KSCibaEngine(this.b.e);
            }
            this.b.d.installEngine(j.a, 65894897);
        } catch (Throwable th) {
        }
        TaskHandler.postTask(this.a);
    }
}
