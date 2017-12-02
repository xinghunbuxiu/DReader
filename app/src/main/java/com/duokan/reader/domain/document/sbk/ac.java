package com.duokan.reader.domain.document.sbk;

class ac implements Runnable {
    final /* synthetic */ y a;

    ac(y yVar) {
        this.a = yVar;
    }

    public void run() {
        this.a.k = true;
        if (this.a.i.c()) {
            this.a.e();
            this.a.j = false;
        }
        if (this.a.h != null) {
            this.a.h.a(null, this.a);
        }
        this.a.invalidateSelf();
    }
}
