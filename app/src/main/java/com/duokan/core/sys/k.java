package com.duokan.core.sys;

final class k implements Runnable {
    final /* synthetic */ s a;
    final /* synthetic */ int b;
    private boolean c = false;

    k(s sVar, int i) {
        this.a = sVar;
        this.b = i;
    }

    public void run() {
        if (!this.c) {
            this.c = true;
            if (this.a.idleRun()) {
                j.a(this.a, this.b);
            }
        }
    }
}
