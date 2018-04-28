package com.duokan.reader.domain.bookshelf;

class hh implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0800c f3301a;
    /* renamed from: b */
    final /* synthetic */ hc f3302b;

    hh(hc hcVar, C0800c c0800c) {
        this.f3302b = hcVar;
        this.f3301a = c0800c;
    }

    public void run() {
        if (this.f3302b.m3847g(this.f3301a)) {
            de.m4313a().m4339a(this.f3301a.aq(), this.f3301a.ar(), this.f3301a.az());
        }
    }
}
