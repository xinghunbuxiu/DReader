package com.duokan.core.sys;

class ay implements at {
    /* renamed from: a */
    public final ax f681a;
    /* renamed from: b */
    public final aw f682b;
    /* renamed from: c */
    public boolean f683c = true;

    public ay(ax axVar, aw awVar) {
        this.f681a = axVar;
        this.f682b = awVar;
    }

    public ay(ay ayVar) {
        this.f681a = ayVar.f681a;
        this.f682b = ayVar.f682b;
        this.f683c = ayVar.f683c;
    }

    /* renamed from: c */
    public long m931c() {
        return this.f681a.f673d.get();
    }

    /* renamed from: a */
    public void m928a(long j) {
        long j2;
        do {
            j2 = this.f681a.f673d.get();
            if (j2 >= j) {
                return;
            }
        } while (!this.f681a.f673d.compareAndSet(j2, j));
    }

    /* renamed from: a */
    public boolean mo412a() {
        return this.f683c;
    }

    /* renamed from: b */
    public long mo413b() {
        return this.f681a.f675f.get();
    }
}
