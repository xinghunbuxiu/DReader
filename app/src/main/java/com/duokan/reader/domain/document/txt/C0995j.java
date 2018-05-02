package com.duokan.reader.domain.document.txt;

/* renamed from: com.duokan.reader.domain.document.txt.j */
class C0995j implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0993h f4971a;

    C0995j(C0993h c0993h) {
        this.f4971a = c0993h;
    }

    public void run() {
        if (this.f4971a.f4969a.f4959j.m7500d()) {
            this.f4971a.f4969a.f4961l.mo1285H();
            this.f4971a.f4969a.f4962m.mo1285H();
            return;
        }
        this.f4971a.f4969a.f4961l.setCallback(this.f4971a.f4969a.f4958i);
        this.f4971a.f4969a.f4962m.setCallback(this.f4971a.f4969a.f4958i);
        this.f4971a.f4969a.invalidateSelf();
    }
}
