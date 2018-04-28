package com.duokan.reader.domain.bookshelf;

class id implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0800c f3341a;
    /* renamed from: b */
    final /* synthetic */ String f3342b;
    /* renamed from: c */
    final /* synthetic */ hc f3343c;

    id(hc hcVar, C0800c c0800c, String str) {
        this.f3343c = hcVar;
        this.f3341a = c0800c;
        this.f3342b = str;
    }

    public void run() {
        if (this.f3343c.m3847g(this.f3341a)) {
            bu.m4077a().m4106a(this.f3341a.aq(), this.f3341a.ar(), this.f3342b);
        }
    }
}
