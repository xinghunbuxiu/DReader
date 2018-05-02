package com.duokan.reader.ui.reading;

class ge implements Runnable {
    final /* synthetic */ gd a;

    ge(gd gdVar) {
        this.a = gdVar;
    }

    public void run() {
        this.a.c.setMinZoomFactor(this.a.c.i());
    }
}
