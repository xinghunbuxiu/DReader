package com.duokan.reader.domain.document.epub;

class bd implements Runnable {
    final /* synthetic */ az a;

    bd(az azVar) {
        this.a = azVar;
    }

    public void run() {
        this.a.n = true;
        if (this.a.j.d()) {
            this.a.V();
            this.a.m = false;
        }
        if (this.a.i != null) {
            this.a.i.a(null, this.a);
        }
        this.a.invalidateSelf();
    }
}
