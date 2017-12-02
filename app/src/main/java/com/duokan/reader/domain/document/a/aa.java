package com.duokan.reader.domain.document.a;

class aa implements Runnable {
    final /* synthetic */ w a;

    aa(w wVar) {
        this.a = wVar;
    }

    public void run() {
        this.a.k = true;
        if (this.a.i.c()) {
            this.a.d();
            this.a.j = false;
        } else if (this.a.U() && this.a.o == null && this.a.p == null && !this.a.h().isEmpty()) {
            float h = this.a.e();
            this.a.p = this.a.a(this.a.P(), h);
        }
        if (this.a.h != null) {
            this.a.h.a(null, this.a);
        }
        this.a.invalidateSelf();
    }
}
