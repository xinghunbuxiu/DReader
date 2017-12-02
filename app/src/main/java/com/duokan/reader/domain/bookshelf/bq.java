package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.s;

import java.util.concurrent.Semaphore;

class bq implements s {
    final /* synthetic */ Semaphore a;
    final /* synthetic */ bp b;

    bq(bp bpVar, Semaphore semaphore) {
        this.b = bpVar;
        this.a = semaphore;
    }

    public boolean idleRun() {
        this.a.release();
        return false;
    }
}
