package com.duokan.reader.common.b;

class b implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ a c;

    b(a aVar, boolean z, Runnable runnable) {
        this.c = aVar;
        this.a = z;
        this.b = runnable;
    }

    public void run() {
        if (this.a) {
            this.c.g();
        }
        if (this.b != null) {
            this.b.run();
        }
    }
}
