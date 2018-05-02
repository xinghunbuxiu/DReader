package com.duokan.reader.ui.surfing;

/* renamed from: com.duokan.reader.ui.surfing.y */
class C1538y implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Runnable f11592a;
    /* renamed from: b */
    final /* synthetic */ Runnable f11593b;
    /* renamed from: c */
    final /* synthetic */ C1522i f11594c;

    C1538y(C1522i c1522i, Runnable runnable, Runnable runnable2) {
        this.f11594c = c1522i;
        this.f11592a = runnable;
        this.f11593b = runnable2;
    }

    public void run() {
        this.f11594c.m15495c(this.f11592a, this.f11593b);
    }
}
