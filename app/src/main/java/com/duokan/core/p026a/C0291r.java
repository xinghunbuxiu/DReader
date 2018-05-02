package com.duokan.core.p026a;


class C0291r implements Runnable {
    
    final  C0290q f491a;

    C0291r(C0290q c0290q) {
        this.f491a = c0290q;
    }

    public void run() {
        this.f491a.f490d.f477b.lock();
        try {
            if (this.f491a.f490d.f480e) {
                this.f491a.f490d.m653a(this.f491a.f488b, this.f491a.f489c);
            } else {
                this.f491a.f490d.f479d.mo383c();
                this.f491a.f490d.m653a(this.f491a.f488b, this.f491a.f489c);
                this.f491a.f490d.f479d.mo382b();
            }
            this.f491a.f490d.f477b.unlock();
            this.f491a.f490d.f481f = false;
        } catch (Throwable th) {
            this.f491a.f490d.f477b.unlock();
            this.f491a.f490d.f481f = false;
        }
    }
}
