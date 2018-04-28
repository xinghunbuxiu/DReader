package com.duokan.core.ui;

class cx implements Runnable {
    /* renamed from: a */
    final /* synthetic */ cv f1118a;

    cx(cv cvVar) {
        this.f1118a = cvVar;
    }

    public void run() {
        if (this.f1118a.f1112t == this) {
            this.f1118a.f1112t = null;
            this.f1118a.doDismiss();
        }
    }
}
