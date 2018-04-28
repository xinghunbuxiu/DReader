package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.af;
import com.duokan.core.sys.ag;
import java.util.Map;
import java.util.concurrent.Semaphore;

class fb implements ag<Map<String, ex>> {
    /* renamed from: a */
    final /* synthetic */ af f3155a;
    /* renamed from: b */
    final /* synthetic */ Semaphore f3156b;
    /* renamed from: c */
    final /* synthetic */ fa f3157c;

    fb(fa faVar, af afVar, Semaphore semaphore) {
        this.f3157c = faVar;
        this.f3155a = afVar;
        this.f3156b = semaphore;
    }

    public /* synthetic */ void run(Object obj) {
        m4446a((Map) obj);
    }

    /* renamed from: a */
    public void m4446a(Map<String, ex> map) {
        this.f3155a.mo975a((Object) map);
        this.f3156b.release();
    }
}
