package com.duokan.reader.ui.general;

class dv implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ ds b;

    dv(ds dsVar, int i) {
        this.b = dsVar;
        this.a = i;
    }

    public void run() {
        this.b.l.b(this.a);
    }
}
