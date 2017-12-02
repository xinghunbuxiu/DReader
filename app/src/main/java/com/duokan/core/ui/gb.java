package com.duokan.core.ui;

class gb implements Runnable {
    final /* synthetic */ ga a;

    gb(ga gaVar) {
        this.a = gaVar;
    }

    public void run() {
        if (this.a.a.i == this) {
            this.a.a.i = null;
            if (this.a.a.f) {
                this.a.a.a.stopLoading();
                this.a.a.g = -8;
                if (this.a.a.c != null) {
                    this.a.a.c.onReceivedError(this.a.a, this.a.a.g, "loading timeout", this.a.a.e);
                }
            }
        }
    }
}
