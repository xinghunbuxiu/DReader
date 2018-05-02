package com.duokan.core.sys;

class am implements Runnable {
    /* renamed from: a */
    final /* synthetic */ al f647a;

    am(al alVar) {
        this.f647a = alVar;
    }

    public void run() {
        ah.f639c.remove(this.f647a);
        this.f647a.f646b = false;
        ah.m872b(this.f647a.f645a);
    }
}
