package com.duokan.core.ui;

class bo implements Runnable {
    final /* synthetic */ bn a;

    bo(bn bnVar) {
        this.a = bnVar;
    }

    public void run() {
        if (this.a.a.g.a != this.a.a.g.b) {
            this.a.a.b(this.a.a.g.a, this.a.a.g.b, this.a.a.e);
        }
        this.a.a.g = null;
    }
}
