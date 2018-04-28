package com.duokan.reader.domain.bookshelf;

import java.util.concurrent.Semaphore;

class en implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Semaphore f3112a;
    /* renamed from: b */
    final /* synthetic */ ee f3113b;

    en(ee eeVar, Semaphore semaphore) {
        this.f3113b = eeVar;
        this.f3112a = semaphore;
    }

    public void run() {
        this.f3113b.m4410a(true, new eo(this), new ep(this));
    }
}
