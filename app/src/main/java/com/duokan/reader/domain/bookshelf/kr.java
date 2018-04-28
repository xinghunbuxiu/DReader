package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.ag;
import java.util.Map;
import java.util.concurrent.Semaphore;

class kr implements ag<Map<String, Integer>> {
    /* renamed from: a */
    final /* synthetic */ Semaphore f3476a;
    /* renamed from: b */
    final /* synthetic */ kq f3477b;

    kr(kq kqVar, Semaphore semaphore) {
        this.f3477b = kqVar;
        this.f3476a = semaphore;
    }

    public /* synthetic */ void run(Object obj) {
        m4850a((Map) obj);
    }

    /* renamed from: a */
    public void m4850a(Map<String, Integer> map) {
        this.f3476a.release();
    }
}
