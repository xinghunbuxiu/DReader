package com.duokan.core.sys;

class az extends ay {
    public az(ax axVar, aw awVar) {
        super(axVar, awVar);
    }

    public az(az azVar) {
        super(azVar);
    }

    /* renamed from: d */
    public long m934d() {
        return this.a.f674e.get();
    }

    /* renamed from: b */
    public void m932b(long j) {
        long j2;
        do {
            j2 = this.a.f675f.get();
            if (j2 >= j) {
                return;
            }
        } while (!this.a.f675f.compareAndSet(j2, j));
    }

    /* renamed from: c */
    public void m933c(long j) {
        m928a(j);
        long j2;
        do {
            j2 = this.a.f674e.get();
            if (j2 >= j) {
                return;
            }
        } while (!this.a.f674e.compareAndSet(j2, j));
    }
}
