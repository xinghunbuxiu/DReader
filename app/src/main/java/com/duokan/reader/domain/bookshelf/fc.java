package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.ag;
import java.util.Map;
import java.util.concurrent.Semaphore;

class fc implements ag<Map<String, Integer>> {
    /* renamed from: a */
    final /* synthetic */ Semaphore f3158a;
    /* renamed from: b */
    final /* synthetic */ fa f3159b;

    fc(fa faVar, Semaphore semaphore) {
        this.f3159b = faVar;
        this.f3158a = semaphore;
    }

    public /* synthetic */ void run(Object obj) {
        m4447a((Map) obj);
    }

    /* renamed from: a */
    public void m4447a(Map<String, Integer> map) {
        this.f3158a.release();
    }
}
