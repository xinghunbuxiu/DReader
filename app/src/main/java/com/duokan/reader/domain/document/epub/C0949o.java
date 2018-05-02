package com.duokan.reader.domain.document.epub;

/* renamed from: com.duokan.reader.domain.document.epub.o */
class C0949o implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0948n f4719a;

    C0949o(C0948n c0948n) {
        this.f4719a = c0948n;
    }

    public void run() {
        if (this.f4719a.f4718c.mo1299a()) {
            this.f4719a.f4718c.f4700l.mo1297a(new C0950p(this), this.f4719a.f4716a);
        } else {
            this.f4719a.f4716a.run();
        }
    }
}
