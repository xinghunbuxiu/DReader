package com.duokan.reader.domain.downloadcenter;

/* renamed from: com.duokan.reader.domain.downloadcenter.v */
class C1034v implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1028p f5114a;
    /* renamed from: b */
    final /* synthetic */ boolean f5115b;
    /* renamed from: c */
    final /* synthetic */ C1030r f5116c;

    C1034v(C1030r c1030r, C1028p c1028p, boolean z) {
        this.f5116c = c1030r;
        this.f5114a = c1028p;
        this.f5115b = z;
    }

    public void run() {
        this.f5114a.m7915a(this.f5115b);
    }
}
