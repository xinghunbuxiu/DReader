package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.ag;

import java.util.Map;
import java.util.concurrent.Semaphore;

class fi implements ag {
    final /* synthetic */ Semaphore a;
    final /* synthetic */ fg b;

    fi(fg fgVar, Semaphore semaphore) {
        this.b = fgVar;
        this.a = semaphore;
    }

    public void a(Map map) {
        this.a.release();
    }
}
