package com.duokan.reader.domain.document.txt;

class l implements Runnable {
    final /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
    }

    public void run() {
        if (this.a.c.a()) {
            this.a.c.l.a(new m(this), this.a.a);
        } else {
            this.a.a.run();
        }
    }
}
