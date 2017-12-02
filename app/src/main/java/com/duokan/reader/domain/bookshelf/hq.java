package com.duokan.reader.domain.bookshelf;

class hq implements Runnable {
    final /* synthetic */ hp a;

    hq(hp hpVar) {
        this.a = hpVar;
    }

    public void run() {
        this.a.b.a.remove(this.a.a);
        this.a.c.w = this.a.c.w - 1;
        this.a.c.G();
    }
}
