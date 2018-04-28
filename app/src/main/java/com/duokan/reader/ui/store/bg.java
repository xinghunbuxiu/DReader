package com.duokan.reader.ui.store;

class bg implements Runnable {
    /* renamed from: a */
    final /* synthetic */ int f11365a;
    /* renamed from: b */
    final /* synthetic */ bc f11366b;

    bg(bc bcVar, int i) {
        this.f11366b = bcVar;
        this.f11365a = i;
    }

    public void run() {
        this.f11366b.f11357a.m10356f(this.f11365a);
        this.f11366b.m1259e(this.f11366b.f11357a.mo2457h(this.f11365a) - 1);
    }
}
