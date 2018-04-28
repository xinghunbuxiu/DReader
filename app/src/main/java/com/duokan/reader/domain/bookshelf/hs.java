package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.UThread;
import com.duokan.core.sys.ag;
import com.duokan.reader.domain.store.DkStoreFictionDetail;

class hs implements ag<DkStoreFictionDetail> {
    /* renamed from: a */
    final /* synthetic */ Runnable f3323a;
    /* renamed from: b */
    final /* synthetic */ hc f3324b;

    hs(hc hcVar, Runnable runnable) {
        this.f3324b = hcVar;
        this.f3323a = runnable;
    }

    public /* synthetic */ void run(Object obj) {
        m4658a((DkStoreFictionDetail) obj);
    }

    /* renamed from: a */
    public void m4658a(DkStoreFictionDetail dkStoreFictionDetail) {
        UThread.runOnThread(this.f3323a);
    }
}
