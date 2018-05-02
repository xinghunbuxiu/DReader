package com.duokan.reader.ui.reading;

class aai implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ zo b;

    aai(zo zoVar, Runnable runnable) {
        this.b = zoVar;
        this.a = runnable;
    }

    public void run() {
        this.b.N.a(Boolean.valueOf(true));
        this.a.run();
    }
}
