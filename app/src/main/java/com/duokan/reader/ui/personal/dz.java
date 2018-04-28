package com.duokan.reader.ui.personal;

class dz implements Runnable {
    /* renamed from: a */
    final /* synthetic */ dm f8477a;

    dz(dm dmVar) {
        this.f8477a = dmVar;
    }

    public void run() {
        if (this.f8477a.f8457b != null && this.f8477a.isDelayedRunnableOnActive(this)) {
            this.f8477a.f8457b.m11528i();
        }
    }
}
