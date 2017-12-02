package com.duokan.core.ui;

class fc implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ ev b;

    fc(ev evVar, Runnable runnable) {
        this.b = evVar;
        this.a = runnable;
    }

    public void run() {
        if (this.a != null) {
            this.b.a.post(this.a);
        }
    }
}
