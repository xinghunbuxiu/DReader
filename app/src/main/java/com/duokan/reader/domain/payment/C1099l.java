package com.duokan.reader.domain.payment;

import com.duokan.core.sys.ag;
import com.duokan.p023b.C0247i;
import com.duokan.reader.domain.store.DkStoreCallback.AbortPayErrorCode;

/* renamed from: com.duokan.reader.domain.payment.l */
class C1099l implements ag<PaymentResult> {
    /* renamed from: a */
    final /* synthetic */ C1089s f5354a;
    /* renamed from: b */
    final /* synthetic */ C1098k f5355b;

    C1099l(C1098k c1098k, C1089s c1089s) {
        this.f5355b = c1098k;
        this.f5354a = c1089s;
    }

    public /* synthetic */ void run(Object obj) {
        m8383a((PaymentResult) obj);
    }

    /* renamed from: a */
    public void m8383a(PaymentResult paymentResult) {
        if (paymentResult == PaymentResult.UNVERIFIED) {
            this.f5355b.f5352c.mo1165a(this.f5354a, this.f5355b.f5353d.f5323h.getString(C0247i.bookcity_store__shared__fail_to_verify_payment), AbortPayErrorCode.NORMAL);
        } else {
            this.f5355b.f5352c.mo1163a(this.f5354a, paymentResult);
        }
    }
}
