package com.duokan.reader.domain.document.epub;

class bd implements Runnable {
    /* renamed from: a */
    final /* synthetic */ az f4551a;

    bd(az azVar) {
        this.f4551a = azVar;
    }

    public void run() {
        this.f4551a.f4533n = true;
        if (this.f4551a.f4529j.m6797d()) {
            this.f4551a.m6540U();
            this.f4551a.f4532m = false;
        }
        if (this.f4551a.f4528i != null) {
            this.f4551a.f4528i.mo1221a(null, this.f4551a);
        }
        this.f4551a.invalidateSelf();
    }
}
