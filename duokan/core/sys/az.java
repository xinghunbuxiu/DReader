package com.duokan.core.sys;

class az extends ay {
    public az(ax axVar, aw awVar) {
        super(axVar, awVar);
    }

    public az(az azVar) {
        super(azVar);
    }

    public long d() {
        return this.a.e.get();
    }

    public void b(long j) {
        long j2;
        do {
            j2 = this.a.f.get();
            if (j2 >= j) {
                return;
            }
        } while (!this.a.f.compareAndSet(j2, j));
    }

    public void c(long j) {
        a(j);
        long j2;
        do {
            j2 = this.a.e.get();
            if (j2 >= j) {
                return;
            }
        } while (!this.a.e.compareAndSet(j2, j));
    }
}
