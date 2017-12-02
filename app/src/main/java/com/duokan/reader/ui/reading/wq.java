package com.duokan.reader.ui.reading;

class wq implements Runnable {
    final /* synthetic */ wl a;

    wq(wl wlVar) {
        this.a = wlVar;
    }

    public void run() {
        this.a.l();
        if (this.a.g != null) {
            this.a.g.recycle();
            this.a.g = null;
        }
        this.a.h = null;
        this.a.invalidate();
    }
}
