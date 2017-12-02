package com.duokan.core.app;

class p implements Runnable {
    final /* synthetic */ m a;

    p(m mVar) {
        this.a = mVar;
    }

    public void run() {
        this.a.n = null;
        this.a.updateScreenBrightness();
    }
}
