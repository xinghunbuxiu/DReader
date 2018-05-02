package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.af;
import com.duokan.core.sys.ag;

import java.util.Map;
import java.util.concurrent.Semaphore;

class fh implements ag {
    final /* synthetic */ af a;
    final /* synthetic */ Semaphore b;
    final /* synthetic */ fg c;

    fh(fg fgVar, af afVar, Semaphore semaphore) {
        this.c = fgVar;
        this.a = afVar;
        this.b = semaphore;
    }

    public void a(Map map) {
        this.a.a((Object) map);
        this.b.release();
    }
}
