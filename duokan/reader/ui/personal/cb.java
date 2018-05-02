package com.duokan.reader.ui.personal;

import com.duokan.core.sys.TaskHandler;
import com.duokan.reader.domain.cloud.a;

class cb implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ ca b;

    cb(ca caVar, a aVar) {
        this.b = caVar;
        this.a = aVar;
    }

    public void run() {
        if (this.b.d.i != this.b.a) {
            this.b.d.i = this.b.a;
            this.b.d.j = this.b.b;
            this.b.d.g = this.a;
            if (this.b.d.k != null && this.b.d.k.isAttached()) {
                this.b.d.k.a(this.b.d.i);
            }
            TaskHandler.PostTask(this.b.c);
        }
    }
}
