package com.duokan.reader.ui.surfing;

class o implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ f c;

    o(f fVar, Runnable runnable, Runnable runnable2) {
        this.c = fVar;
        this.a = runnable;
        this.b = runnable2;
    }

    public void run() {
        this.c.a(this.a, this.b);
    }
}
