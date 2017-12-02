package com.duokan.reader.ui.reading;

class aah implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ zo b;

    aah(zo zoVar, Runnable runnable) {
        this.b = zoVar;
        this.a = runnable;
    }

    public void run() {
        this.b.N.a(Boolean.valueOf(false));
        this.a.run();
    }
}
