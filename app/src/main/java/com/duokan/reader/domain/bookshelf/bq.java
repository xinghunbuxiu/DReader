package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.IdleStatus;

import java.util.concurrent.Semaphore;

class bq implements IdleStatus {
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
