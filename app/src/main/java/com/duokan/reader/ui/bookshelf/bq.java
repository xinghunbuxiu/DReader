package com.duokan.reader.ui.bookshelf;

class bq implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Runnable f6204a;
    /* renamed from: b */
    final /* synthetic */ boolean f6205b;
    /* renamed from: c */
    final /* synthetic */ bp f6206c;

    bq(bp bpVar, Runnable runnable, boolean z) {
        this.f6206c = bpVar;
        this.f6204a = runnable;
        this.f6205b = z;
    }

    public void run() {
        if (this.f6204a != null) {
            this.f6204a.run();
        }
        if (this.f6206c.f6199j != null) {
            this.f6206c.f6199j.m9181e();
        }
        if (this.f6205b && this.f6206c.f6197h != null) {
            this.f6206c.f6197h.m9519d();
        }
    }
}
