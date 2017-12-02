package com.duokan.reader.ui.bookshelf;

import com.duokan.core.ui.dv;

class e implements Runnable {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public void run() {
        if (this.a.a.a != null) {
            this.a.a.a.e();
        }
        dv.c(this.a.a.b, new f(this));
    }
}
