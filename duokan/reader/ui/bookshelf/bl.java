package com.duokan.reader.ui.bookshelf;

class bl implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ boolean b;
    final /* synthetic */ bk c;

    bl(bk bkVar, Runnable runnable, boolean z) {
        this.c = bkVar;
        this.a = runnable;
        this.b = z;
    }

    public void run() {
        if (this.a != null) {
            this.a.run();
        }
        if (this.c.j != null) {
            this.c.j.e();
        }
        if (this.b && this.c.h != null) {
            this.c.h.d();
        }
    }
}
