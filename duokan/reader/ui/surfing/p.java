package com.duokan.reader.ui.surfing;

class p implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ f c;

    p(f fVar, Runnable runnable, Runnable runnable2) {
        this.c = fVar;
        this.a = runnable;
        this.b = runnable2;
    }

    public void run() {
        this.c.b(this.a, this.b);
    }
}
