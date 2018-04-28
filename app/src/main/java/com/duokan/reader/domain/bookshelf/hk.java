package com.duokan.reader.domain.bookshelf;

class hk implements Runnable {
    /* renamed from: a */
    final /* synthetic */ hj f3308a;

    hk(hj hjVar) {
        this.f3308a = hjVar;
    }

    public void run() {
        this.f3308a.f3306b.f2687a.remove(this.f3308a.f3305a);
        this.f3308a.f3307c.f2758w = this.f3308a.f3307c.f2758w - 1;
        this.f3308a.f3307c.m3807G();
    }
}
