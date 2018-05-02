package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.ag;

import java.util.Map;
import java.util.concurrent.Semaphore;

class kf implements ag {
    final /* synthetic */ Semaphore a;
    final /* synthetic */ ke b;

    kf(ke keVar, Semaphore semaphore) {
        this.b = keVar;
        this.a = semaphore;
    }

    public void a(Map map) {
        this.a.release();
    }
}
