package com.duokan.reader.domain.payment;

import android.app.Activity;
import android.os.Bundle;

import com.duokan.b.i;
import com.duokan.core.diagnostic.LogLevel;

import miuipub.payment.IXmsfPaymentListener;

final class f implements IXmsfPaymentListener {
    final /* synthetic */ s a;
    final /* synthetic */ i b;
    final /* synthetic */ Activity c;

    f(s sVar, i iVar, Activity activity) {
        this.a = sVar;
        this.b = iVar;
        this.c = activity;
    }

    public void onSuccess(String str, Bundle bundle) {
        a.c().c(LogLevel.EVENT, "pay", String.format("method: %s, order_id: %s, SUCCESS", new Object[]{this.a.d(), this.a.a()}));
        this.b.a(bundle.getString(PaymentManager.PAYMENT_KEY_PAYMENT_RESULT));
    }

    public void onFailed(String str, int i, String str2, Bundle bundle) {
        a.c().c(LogLevel.EVENT, "pay", String.format("method: %s, order_id: %s, error_code: %s, message: %s", new Object[]{this.a.d(), this.a.a(), i + "", str2}));
        if (i == 7) {
            this.b.a(bundle.getString(PaymentManager.PAYMENT_KEY_PAYMENT_RESULT));
        } else if (i == 4) {
            this.b.a();
        } else {
            this.b.a(i, String.format(this.c.getString(i.general__shared__mi_pay_error), new Object[]{Integer.valueOf(i)}));
        }
    }
}
