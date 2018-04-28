package com.duokan.reader.domain.document.epub;

class be implements Runnable {
    /* renamed from: a */
    final /* synthetic */ az f4552a;

    be(az azVar) {
        this.f4552a = azVar;
    }

    public void run() {
        this.f4552a.f4533n = true;
        this.f4552a.m6540U();
        this.f4552a.invalidateSelf();
    }
}
