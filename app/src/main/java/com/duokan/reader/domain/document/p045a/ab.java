package com.duokan.reader.domain.document.p045a;

/* renamed from: com.duokan.reader.domain.document.a.ab */
class ab implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0926w f4224a;

    ab(C0926w c0926w) {
        this.f4224a = c0926w;
    }

    public void run() {
        this.f4224a.f4389k = true;
        this.f4224a.m6221d();
        this.f4224a.invalidateSelf();
    }
}
