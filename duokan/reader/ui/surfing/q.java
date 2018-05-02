package com.duokan.reader.ui.surfing;

class q implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ f c;

    q(f fVar, Runnable runnable, Runnable runnable2) {
        this.c = fVar;
        this.a = runnable;
        this.b = runnable2;
    }

    public void run() {
        this.c.c(this.a, this.b);
    }
}
