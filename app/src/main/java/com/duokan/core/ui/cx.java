package com.duokan.core.ui;

class cx implements Runnable {
    final /* synthetic */ cv a;

    cx(cv cvVar) {
        this.a = cvVar;
    }

    public void run() {
        if (this.a.t == this) {
            this.a.t = null;
            this.a.doDismiss();
        }
    }
}
