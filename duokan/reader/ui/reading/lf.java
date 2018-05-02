package com.duokan.reader.ui.reading;

class lf implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ lb b;

    lf(lb lbVar, Runnable runnable) {
        this.b = lbVar;
        this.a = runnable;
    }

    public void run() {
        this.a.run();
    }
}
