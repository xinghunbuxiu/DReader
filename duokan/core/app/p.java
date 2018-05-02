package com.duokan.core.app;

class p implements Runnable {
    final /* synthetic */ BaseActivity a;

    p(BaseActivity baseActivityVar) {
        this.a = baseActivityVar;
    }

    public void run() {
        this.a.n = null;
        this.a.updateScreenBrightness();
    }
}
