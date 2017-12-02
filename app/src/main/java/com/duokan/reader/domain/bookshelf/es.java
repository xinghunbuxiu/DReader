package com.duokan.reader.domain.bookshelf;

import java.util.concurrent.Semaphore;

class es implements Runnable {
    final /* synthetic */ Semaphore a;
    final /* synthetic */ ej b;

    es(ej ejVar, Semaphore semaphore) {
        this.b = ejVar;
        this.a = semaphore;
    }

    public void run() {
        this.b.a(true, new et(this), new eu(this));
    }
}
