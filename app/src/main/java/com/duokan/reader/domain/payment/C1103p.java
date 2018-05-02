package com.duokan.reader.domain.payment;

import com.duokan.core.sys.ag;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.store.C1195u;
import java.util.List;

/* renamed from: com.duokan.reader.domain.payment.p */
class C1103p implements ag<PaymentResult> {
    /* renamed from: a */
    final /* synthetic */ C1195u f5373a;
    /* renamed from: b */
    final /* synthetic */ ag f5374b;
    /* renamed from: c */
    final /* synthetic */ C0672a f5375c;
    /* renamed from: d */
    final /* synthetic */ List f5376d;
    /* renamed from: e */
    final /* synthetic */ PaymentManager f5377e;

    C1103p(PaymentManager paymentManager, C1195u c1195u, ag agVar, C0672a c0672a, List list) {
        this.f5377e = paymentManager;
        this.f5373a = c1195u;
        this.f5374b = agVar;
        this.f5375c = c0672a;
        this.f5376d = list;
    }

    public /* synthetic */ void run(Object obj) {
        m8386a((PaymentResult) obj);
    }

    /* renamed from: a */
    public void m8386a(PaymentResult paymentResult) {
        if (paymentResult == PaymentResult.UNVERIFIED) {
            C1195u c1195u = this.f5373a;
            c1195u.f5690e++;
            if (this.f5373a.f5690e >= 2) {
                m8385a();
            } else {
                this.f5377e.m8348c(this.f5373a);
            }
            this.f5374b.run(PaymentResult.UNVERIFIED);
            return;
        }
        this.f5373a.f5691f = true;
        m8385a();
        this.f5377e.m8340a(this.f5375c, this.f5376d, this.f5374b);
    }

    /* renamed from: a */
    private void m8385a() {
        this.f5377e.m8335a(this.f5373a.f5686a);
    }
}
