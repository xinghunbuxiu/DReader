package com.duokan.reader.domain.bookshelf;

class hq implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0800c f3317a;
    /* renamed from: b */
    final /* synthetic */ long f3318b;
    /* renamed from: c */
    final /* synthetic */ hp f3319c;

    hq(hp hpVar, C0800c c0800c, long j) {
        this.f3319c = hpVar;
        this.f3317a = c0800c;
        this.f3318b = j;
    }

    public void run() {
        this.f3319c.f3316b.m3820a(this.f3317a, this.f3318b);
        this.f3319c.f3316b.m3807G();
    }
}
