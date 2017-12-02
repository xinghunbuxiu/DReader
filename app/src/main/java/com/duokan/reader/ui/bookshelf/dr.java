package com.duokan.reader.ui.bookshelf;

class dr implements Runnable {
    final /* synthetic */ gx a;
    final /* synthetic */ dh b;

    dr(dh dhVar, gx gxVar) {
        this.b = dhVar;
        this.a = gxVar;
    }

    public void run() {
        this.b.c.a(this.a);
    }
}
