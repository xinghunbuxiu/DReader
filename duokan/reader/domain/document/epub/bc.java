package com.duokan.reader.domain.document.epub;

class bc implements Runnable {
    final /* synthetic */ az a;

    bc(az azVar) {
        this.a = azVar;
    }

    public void run() {
        if (!this.a.F()) {
            this.a.invalidateSelf();
        }
    }
}
