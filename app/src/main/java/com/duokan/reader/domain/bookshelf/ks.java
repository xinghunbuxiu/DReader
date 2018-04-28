package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.ag;
import java.util.Map;
import java.util.concurrent.Semaphore;

class ks implements ag<Map<String, Integer>> {
    /* renamed from: a */
    final /* synthetic */ Semaphore f3478a;
    /* renamed from: b */
    final /* synthetic */ kq f3479b;

    ks(kq kqVar, Semaphore semaphore) {
        this.f3479b = kqVar;
        this.f3478a = semaphore;
    }

    public /* synthetic */ void run(Object obj) {
        m4851a((Map) obj);
    }

    /* renamed from: a */
    public void m4851a(Map<String, Integer> map) {
        this.f3478a.release();
    }
}
