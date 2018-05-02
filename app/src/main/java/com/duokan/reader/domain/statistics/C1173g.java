package com.duokan.reader.domain.statistics;

/* renamed from: com.duokan.reader.domain.statistics.g */
class C1173g implements Runnable {
    /* renamed from: a */
    final /* synthetic */ int f5621a;
    /* renamed from: b */
    final /* synthetic */ String f5622b;
    /* renamed from: c */
    final /* synthetic */ C1163a f5623c;

    C1173g(C1163a c1163a, int i, String str) {
        this.f5623c = c1163a;
        this.f5621a = i;
        this.f5622b = str;
    }

    public void run() {
        if (this.f5621a > this.f5623c.f5597i) {
            this.f5623c.f5597i = this.f5621a;
            this.f5623c.f5598j = this.f5622b;
            C1174h c1174h = new C1174h();
            c1174h.f5624a = "m/cold_start/" + this.f5622b;
            this.f5623c.f5595g.add(c1174h);
            this.f5623c.m8628l();
        }
    }
}
