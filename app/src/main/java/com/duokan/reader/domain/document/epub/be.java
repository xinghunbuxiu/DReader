package com.duokan.reader.domain.document.epub;

class be implements Runnable {
    final /* synthetic */ az a;

    be(az azVar) {
        this.a = azVar;
    }

    public void run() {
        this.a.n = true;
        this.a.V();
        this.a.invalidateSelf();
    }
}
