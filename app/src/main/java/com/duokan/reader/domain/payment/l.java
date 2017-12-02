package com.duokan.reader.domain.payment;

import com.duokan.b.i;
import com.duokan.core.sys.ag;
import com.duokan.reader.domain.store.DkStoreCallback.AbortPayErrorCode;

class l implements ag {
    final /* synthetic */ s a;
    final /* synthetic */ k b;

    l(k kVar, s sVar) {
        this.b = kVar;
        this.a = sVar;
    }

    public void a(PaymentResult paymentResult) {
        if (paymentResult == PaymentResult.UNVERIFIED) {
            this.b.c.a(this.a, this.b.d.h.getString(i.bookcity_store__shared__fail_to_verify_payment), AbortPayErrorCode.NORMAL);
        } else {
            this.b.c.a(this.a, paymentResult);
        }
    }
}
