package com.duokan.reader.domain.payment;

import android.content.Context;

import com.duokan.reader.ui.general.ap;

class n extends ap {
    final /* synthetic */ PaymentResult a;
    final /* synthetic */ m b;

    n(m mVar, Context context, PaymentResult paymentResult) {
        this.b = mVar;
        this.a = paymentResult;
        super(context);
    }

    protected void onOk() {
        super.onOk();
        this.b.g.a(this.b.a, this.b.b, this.b.c, this.b.d, this.b.e, this.b.f);
    }

    protected void onNo() {
        super.onNo();
        this.b.f.a(this.a);
    }

    protected void onCancel() {
        super.onCancel();
        this.b.f.a(this.a);
    }
}
