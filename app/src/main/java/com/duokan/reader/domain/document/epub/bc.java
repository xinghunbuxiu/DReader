package com.duokan.reader.domain.document.epub;

class bc implements Runnable {
    /* renamed from: a */
    final /* synthetic */ az f4550a;

    bc(az azVar) {
        this.f4550a = azVar;
    }

    public void run() {
        if (!this.f4550a.mo1283F()) {
            this.f4550a.invalidateSelf();
        }
    }
}
