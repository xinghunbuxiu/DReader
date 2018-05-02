package com.duokan.reader.ui.bookshelf;

/* renamed from: com.duokan.reader.ui.bookshelf.t */
class C1306t implements Runnable {
    /* renamed from: a */
    final /* synthetic */ int f6734a;
    /* renamed from: b */
    final /* synthetic */ boolean f6735b;
    /* renamed from: c */
    final /* synthetic */ C1290g f6736c;

    C1306t(C1290g c1290g, int i, boolean z) {
        this.f6736c = c1290g;
        this.f6734a = i;
        this.f6735b = z;
    }

    public void run() {
        this.f6736c.m9663a(new C1307u(this));
    }
}
