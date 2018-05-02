package com.duokan.reader.common;

/* renamed from: com.duokan.reader.common.p */
class C0617p implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f2052a;
    /* renamed from: b */
    final /* synthetic */ C0616o f2053b;

    C0617p(C0616o c0616o, String str) {
        this.f2053b = c0616o;
        this.f2052a = str;
    }

    public void run() {
        if (this.f2053b.f2051j != null) {
            this.f2053b.f2051j.mo1619a(this.f2052a);
            this.f2053b.f2051j = null;
            this.f2053b.f2049h = false;
        }
    }
}
