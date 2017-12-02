package com.duokan.reader.ui.reading;

class fz implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ fy b;

    fz(fy fyVar, Runnable runnable) {
        this.b = fyVar;
        this.a = runnable;
    }

    public void run() {
        this.b.a((float) (this.b.b != null ? this.b.b.x : this.b.c.getWidth() / 2), (float) (this.b.b != null ? this.b.b.y : this.b.c.getHeight() / 2), this.b.getContentStaticScale(), 0.0f, this.a, this.a);
    }
}
