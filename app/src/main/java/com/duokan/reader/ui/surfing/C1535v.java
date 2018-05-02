package com.duokan.reader.ui.surfing;

/* renamed from: com.duokan.reader.ui.surfing.v */
class C1535v implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Runnable f11585a;
    /* renamed from: b */
    final /* synthetic */ Runnable f11586b;
    /* renamed from: c */
    final /* synthetic */ C1522i f11587c;

    C1535v(C1522i c1522i, Runnable runnable, Runnable runnable2) {
        this.f11587c = c1522i;
        this.f11585a = runnable;
        this.f11586b = runnable2;
    }

    public void run() {
        this.f11587c.m15485a(this.f11585a, this.f11586b);
    }
}
