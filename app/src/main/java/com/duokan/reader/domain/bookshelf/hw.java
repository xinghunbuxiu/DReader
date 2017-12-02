package com.duokan.reader.domain.bookshelf;

class hw implements Runnable {
    final /* synthetic */ c a;
    final /* synthetic */ long b;
    final /* synthetic */ hv c;

    hw(hv hvVar, c cVar, long j) {
        this.c = hvVar;
        this.a = cVar;
        this.b = j;
    }

    public void run() {
        this.c.b.a(this.a, this.b);
        this.c.b.G();
    }
}
