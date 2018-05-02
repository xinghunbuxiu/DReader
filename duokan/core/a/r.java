package com.duokan.core.a;

class r implements Runnable {
    final /* synthetic */ q a;

    r(q qVar) {
        this.a = qVar;
    }

    public void run() {
        this.a.d.b.lock();
        try {
            if (this.a.d.e) {
                this.a.d.a(this.a.b, this.a.c);
            } else {
                this.a.d.d.removeCallbacks();
                this.a.d.a(this.a.b, this.a.c);
                this.a.d.d.getThread();
            }
            this.a.d.b.unlock();
            this.a.d.f = false;
        } catch (Throwable th) {
            this.a.d.b.unlock();
            this.a.d.f = false;
        }
    }
}
