package com.duokan.reader.domain.payment;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.store.DkStoreCallback;
import com.duokan.reader.domain.store.DkStoreCallback.AbortPayErrorCode;

class k implements r {
    final /* synthetic */ a a;
    final /* synthetic */ String b;
    final /* synthetic */ DkStoreCallback c;
    final /* synthetic */ PaymentManager d;

    k(PaymentManager paymentManager, a aVar, String str, DkStoreCallback dkStoreCallback) {
        this.d = paymentManager;
        this.a = aVar;
        this.b = str;
        this.c = dkStoreCallback;
    }

    public void a(q qVar, s sVar, String str) {
        s sVar2 = sVar;
        String str2 = str;
        this.d.a(this.a, this.b, sVar2, str2, this.d.a(this.a.b(), sVar, str, this.b), new l(this, sVar));
    }

    public void b(q qVar, s sVar, String str) {
        this.c.a(sVar, str, AbortPayErrorCode.NORMAL);
    }
}
