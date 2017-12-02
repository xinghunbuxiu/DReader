package com.duokan.reader.ui.store;

class bg implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ bc b;

    bg(bc bcVar, int i) {
        this.b = bcVar;
        this.a = i;
    }

    public void run() {
        this.b.a.f(this.a);
        this.b.e(this.b.a.h(this.a) - 1);
    }
}
