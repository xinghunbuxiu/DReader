package com.duokan.reader.domain.payment;

import com.duokan.b.i;
import com.duokan.core.sys.ag;
import com.duokan.reader.domain.store.DkStoreCallback;
import com.duokan.reader.domain.store.DkStoreCallback.AbortPayErrorCode;

class j implements ag {
    final /* synthetic */ DkStoreCallback a;
    final /* synthetic */ s b;
    final /* synthetic */ PaymentManager c;

    j(PaymentManager paymentManager, DkStoreCallback dkStoreCallback, s sVar) {
        this.c = paymentManager;
        this.a = dkStoreCallback;
        this.b = sVar;
    }

    public void a(PaymentResult paymentResult) {
        this.a.a(this.b, this.c.h.getString(i.bookcity_store__shared__fail_to_has_unverify_payment), AbortPayErrorCode.REPEAT_PAY);
    }
}
