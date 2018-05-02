package com.duokan.core.sys;

class ay implements at {
    public final ax a;
    public final aw b;
    public boolean c = true;

    public ay(ax axVar, aw awVar) {
        this.a = axVar;
        this.b = awVar;
    }

    public ay(ay ayVar) {
        this.a = ayVar.a;
        this.b = ayVar.b;
        this.c = ayVar.c;
    }

    public long c() {
        return this.a.d.get();
    }

    public void a(long j) {
        long j2;
        do {
            j2 = this.a.d.get();
            if (j2 >= j) {
                return;
            }
        } while (!this.a.d.compareAndSet(j2, j));
    }

    public boolean a() {
        return this.c;
    }

    public long b() {
        return this.a.f.get();
    }
}
