package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.ag;
import java.util.Map;
import java.util.concurrent.Semaphore;

class gr implements ag<Map<String, Integer>> {
    /* renamed from: a */
    final /* synthetic */ Semaphore f3251a;
    /* renamed from: b */
    final /* synthetic */ gj f3252b;

    gr(gj gjVar, Semaphore semaphore) {
        this.f3252b = gjVar;
        this.f3251a = semaphore;
    }

    public /* synthetic */ void run(Object obj) {
        m4554a((Map) obj);
    }

    /* renamed from: a */
    public void m4554a(Map<String, Integer> map) {
        this.f3251a.release();
    }
}
