package com.duokan.reader.domain.document.epub;

class m implements Runnable {
    final /* synthetic */ k a;

    m(k kVar) {
        this.a = kVar;
    }

    public void run() {
        if (this.a.a.j.d()) {
            this.a.a.l.H();
            this.a.a.m.H();
            return;
        }
        this.a.a.l.setCallback(this.a.a.i);
        this.a.a.m.setCallback(this.a.a.i);
        this.a.a.invalidateSelf();
    }
}
