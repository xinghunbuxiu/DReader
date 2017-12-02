package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.ag;

import java.util.Map;
import java.util.concurrent.Semaphore;

class gx implements ag {
    final /* synthetic */ Semaphore a;
    final /* synthetic */ gp b;

    gx(gp gpVar, Semaphore semaphore) {
        this.b = gpVar;
        this.a = semaphore;
    }

    public void a(Map map) {
        this.a.release();
    }
}
