package com.duokan.reader.domain.document.epub;

class o implements Runnable {
    final /* synthetic */ n a;

    o(n nVar) {
        this.a = nVar;
    }

    public void run() {
        if (this.a.c.a()) {
            this.a.c.l.a(new p(this), this.a.a);
        } else {
            this.a.a.run();
        }
    }
}
