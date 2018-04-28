package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.UThread;
import com.duokan.reader.domain.store.DkStoreFictionDetail;

class el implements Runnable {
    /* renamed from: a */
    final /* synthetic */ DkStoreFictionDetail f3109a;
    /* renamed from: b */
    final /* synthetic */ ek f3110b;

    el(ek ekVar, DkStoreFictionDetail dkStoreFictionDetail) {
        this.f3110b = ekVar;
        this.f3109a = dkStoreFictionDetail;
    }

    public void run() {
        if (this.f3110b.f3108d.m4417b(this.f3109a)) {
            UThread.runOnThread(this.f3110b.f3105a);
        } else if (this.f3110b.f3106b != null) {
            UThread.runOnThread(new em(this));
        }
    }
}
