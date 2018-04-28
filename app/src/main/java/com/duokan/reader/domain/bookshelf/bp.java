package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.IdleHandlerListener;
import java.util.concurrent.Semaphore;

class bp implements IdleHandlerListener {
    /* renamed from: a */
    final /* synthetic */ Semaphore f2851a;
    /* renamed from: b */
    final /* synthetic */ bo f2852b;

    bp(bo boVar, Semaphore semaphore) {
        this.f2852b = boVar;
        this.f2851a = semaphore;
    }

    public boolean idleRun() {
        this.f2851a.release();
        return false;
    }
}
