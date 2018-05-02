package com.duokan.reader.ui.reading;

class zs implements Runnable {
    final /* synthetic */ zo a;

    zs(zo zoVar) {
        this.a = zoVar;
    }

    public void run() {
        if (!this.a.b) {
            this.a.b = true;
            this.a.E();
        }
    }
}
