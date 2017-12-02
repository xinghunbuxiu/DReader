package com.duokan.reader.ui.reading;

class kl implements Runnable {
    final /* synthetic */ kd a;

    kl(kd kdVar) {
        this.a = kdVar;
    }

    public void run() {
        if (this.a.d.getVisibility() == 0) {
            this.a.g();
        }
    }
}
