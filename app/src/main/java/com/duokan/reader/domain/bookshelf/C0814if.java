package com.duokan.reader.domain.bookshelf;

/* renamed from: com.duokan.reader.domain.bookshelf.if */
class C0814if implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0800c f3345a;
    /* renamed from: b */
    final /* synthetic */ hc f3346b;

    C0814if(hc hcVar, C0800c c0800c) {
        this.f3346b = hcVar;
        this.f3345a = c0800c;
    }

    public void run() {
        if (this.f3346b.m3847g(this.f3345a)) {
            bu.m4077a().m4105a(this.f3345a.aq(), this.f3345a.ar());
        }
    }
}
