package com.duokan.reader.domain.payment;

import android.content.Context;
import com.duokan.reader.ui.general.ap;

/* renamed from: com.duokan.reader.domain.payment.n */
class C1101n extends ap {
    /* renamed from: a */
    final /* synthetic */ PaymentResult f5363a;
    /* renamed from: b */
    final /* synthetic */ C1100m f5364b;

    C1101n(C1100m c1100m, Context context, PaymentResult paymentResult) {
        this.f5364b = c1100m;
        this.f5363a = paymentResult;
        super(context);
    }

    protected void onOk() {
        super.onOk();
        this.f5364b.f5362g.m8339a(this.f5364b.f5356a, this.f5364b.f5357b, this.f5364b.f5358c, this.f5364b.f5359d, this.f5364b.f5360e, this.f5364b.f5361f);
    }

    protected void onNo() {
        super.onNo();
        this.f5364b.f5361f.run(this.f5363a);
    }

    protected void onCancel() {
        super.onCancel();
        this.f5364b.f5361f.run(this.f5363a);
    }
}
