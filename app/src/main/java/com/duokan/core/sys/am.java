package com.duokan.core.sys;

class am implements Runnable {
    final /* synthetic */ al a;

    am(al alVar) {
        this.a = alVar;
    }

    public void run() {
        ah.c.remove(this.a);
        this.a.b = false;
        ah.b(this.a.a);
    }
}
