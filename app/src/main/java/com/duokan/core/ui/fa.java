package com.duokan.core.ui;

class fa implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ ev b;

    fa(ev evVar, Runnable runnable) {
        this.b = evVar;
        this.a = runnable;
    }

    public void run() {
        if (this.a != null) {
            this.b.a.post(this.a);
        }
    }
}
