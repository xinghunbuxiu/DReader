package com.duokan.reader.domain.payment;

import com.duokan.core.sys.ag;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.store.u;

import java.util.List;

class p implements ag {
    final /* synthetic */ u a;
    final /* synthetic */ ag b;
    final /* synthetic */ a c;
    final /* synthetic */ List d;
    final /* synthetic */ PaymentManager e;

    p(PaymentManager paymentManager, u uVar, ag agVar, a aVar, List list) {
        this.e = paymentManager;
        this.a = uVar;
        this.b = agVar;
        this.c = aVar;
        this.d = list;
    }

    public void a(PaymentResult paymentResult) {
        if (paymentResult == PaymentResult.UNVERIFIED) {
            u uVar = this.a;
            uVar.e++;
            if (this.a.e >= 2) {
                a();
            } else {
                this.e.c(this.a);
            }
            this.b.a(PaymentResult.UNVERIFIED);
            return;
        }
        this.a.f = true;
        a();
        this.e.a(this.c, this.d, this.b);
    }

    private void a() {
        this.e.a(this.a.a);
    }
}
