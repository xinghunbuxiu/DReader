package com.duokan.reader.domain.document.txt;

class j implements Runnable {
    final /* synthetic */ h a;

    j(h hVar) {
        this.a = hVar;
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
