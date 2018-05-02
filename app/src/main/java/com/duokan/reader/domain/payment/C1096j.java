package com.duokan.reader.domain.payment;

import com.duokan.core.sys.ag;
import com.duokan.p023b.C0247i;
import com.duokan.reader.domain.store.DkStoreCallback;
import com.duokan.reader.domain.store.DkStoreCallback.AbortPayErrorCode;

/* renamed from: com.duokan.reader.domain.payment.j */
class C1096j implements ag<PaymentResult> {
    /* renamed from: a */
    final /* synthetic */ DkStoreCallback f5347a;
    /* renamed from: b */
    final /* synthetic */ C1089s f5348b;
    /* renamed from: c */
    final /* synthetic */ PaymentManager f5349c;

    C1096j(PaymentManager paymentManager, DkStoreCallback dkStoreCallback, C1089s c1089s) {
        this.f5349c = paymentManager;
        this.f5347a = dkStoreCallback;
        this.f5348b = c1089s;
    }

    public /* synthetic */ void run(Object obj) {
        m8378a((PaymentResult) obj);
    }

    /* renamed from: a */
    public void m8378a(PaymentResult paymentResult) {
        this.f5347a.mo1165a(this.f5348b, this.f5349c.f5323h.getString(C0247i.bookcity_store__shared__fail_to_has_unverify_payment), AbortPayErrorCode.REPEAT_PAY);
    }
}
