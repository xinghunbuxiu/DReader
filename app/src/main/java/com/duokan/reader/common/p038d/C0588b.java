package com.duokan.reader.common.p038d;

/* renamed from: com.duokan.reader.common.d.b */
class C0588b implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0587a f1921a;

    C0588b(C0587a c0587a) {
        this.f1921a = c0587a;
    }

    public void run() {
        Object obj = 1;
        this.f1921a.f1920j = null;
        synchronized (this.f1921a) {
            if (this.f1921a.f1919i) {
                obj = null;
            } else {
                this.f1921a.f1919i = true;
            }
        }
        if (obj != null) {
            this.f1921a.f1912b.mo974a(this.f1921a);
        }
    }
}
