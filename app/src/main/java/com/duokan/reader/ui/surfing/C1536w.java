package com.duokan.reader.ui.surfing;

/* renamed from: com.duokan.reader.ui.surfing.w */
class C1536w implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Runnable f11588a;
    /* renamed from: b */
    final /* synthetic */ Runnable f11589b;
    /* renamed from: c */
    final /* synthetic */ C1522i f11590c;

    C1536w(C1522i c1522i, Runnable runnable, Runnable runnable2) {
        this.f11590c = c1522i;
        this.f11588a = runnable;
        this.f11589b = runnable2;
    }

    public void run() {
        this.f11590c.m15492b(this.f11588a, this.f11589b);
    }
}
