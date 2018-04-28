package com.duokan.reader.ui.reading;

import com.duokan.core.sys.UThread;
import com.duokan.core.sys.ag;
import com.duokan.reader.domain.store.DkStoreFictionDetail;

class rk implements ag<DkStoreFictionDetail> {
    /* renamed from: a */
    final /* synthetic */ Runnable f10898a;
    /* renamed from: b */
    final /* synthetic */ qr f10899b;

    rk(qr qrVar, Runnable runnable) {
        this.f10899b = qrVar;
        this.f10898a = runnable;
    }

    public /* synthetic */ void run(Object obj) {
        m14947a((DkStoreFictionDetail) obj);
    }

    /* renamed from: a */
    public void m14947a(DkStoreFictionDetail dkStoreFictionDetail) {
        if (!this.f10899b.f9293q) {
            this.f10899b.m12790a(dkStoreFictionDetail);
            UThread.post(this.f10898a);
        }
    }
}
