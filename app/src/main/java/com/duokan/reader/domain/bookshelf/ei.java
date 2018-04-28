package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.UThread;
import com.duokan.reader.domain.store.DkStoreFictionDetail;

class ei implements Runnable {
    /* renamed from: a */
    final /* synthetic */ DkStoreFictionDetail f3102a;
    /* renamed from: b */
    final /* synthetic */ eh f3103b;

    ei(eh ehVar, DkStoreFictionDetail dkStoreFictionDetail) {
        this.f3103b = ehVar;
        this.f3102a = dkStoreFictionDetail;
    }

    public void run() {
        this.f3103b.f3101a.f3100c.m4418c(this.f3102a);
        this.f3103b.f3101a.f3100c.aN();
        if (this.f3103b.f3101a.f3098a != null) {
            UThread.runOnThread(new ej(this));
        }
    }
}
