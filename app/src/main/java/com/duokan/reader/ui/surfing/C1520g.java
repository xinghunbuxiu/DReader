package com.duokan.reader.ui.surfing;

/* renamed from: com.duokan.reader.ui.surfing.g */
class C1520g implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1514a f11524a;

    C1520g(C1514a c1514a) {
        this.f11524a = c1514a;
    }

    public void run() {
        this.f11524a.dismiss();
        if (this.f11524a.f11496f != null) {
            this.f11524a.f11496f.run();
        }
    }
}
