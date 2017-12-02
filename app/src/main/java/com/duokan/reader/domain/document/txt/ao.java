package com.duokan.reader.domain.document.txt;

class ao implements Runnable {
    final /* synthetic */ aj a;

    ao(aj ajVar) {
        this.a = ajVar;
    }

    public void run() {
        this.a.k = true;
        if (this.a.i.d()) {
            this.a.d();
            this.a.j = false;
        }
        if (this.a.h != null) {
            this.a.h.a(null, this.a);
        }
        this.a.invalidateSelf();
    }
}
