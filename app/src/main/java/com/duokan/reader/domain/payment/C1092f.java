package com.duokan.reader.domain.payment;

import android.app.Activity;
import android.os.Bundle;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.p023b.C0247i;
import miui.payment.PaymentManager;
import miuipub.payment.IXmsfPaymentListener;

/* renamed from: com.duokan.reader.domain.payment.f */
final class C1092f implements IXmsfPaymentListener {
    /* renamed from: a */
    final /* synthetic */ C1089s f5341a;
    /* renamed from: b */
    final /* synthetic */ C1094i f5342b;
    /* renamed from: c */
    final /* synthetic */ Activity f5343c;

    C1092f(C1089s c1089s, C1094i c1094i, Activity activity) {
        this.f5341a = c1089s;
        this.f5342b = c1094i;
        this.f5343c = activity;
    }

    public void onSuccess(String str, Bundle bundle) {
        WebLog.init().c(LogLevel.EVENT, "pay", String.format("method: %s, order_id: %s, SUCCESS", new Object[]{this.f5341a.mo1504d(), this.f5341a.mo1501a()}));
        this.f5342b.mo1507a(bundle.getString(PaymentManager.PAYMENT_KEY_PAYMENT_RESULT));
    }

    public void onFailed(String str, int i, String str2, Bundle bundle) {
        WebLog.init().c(LogLevel.EVENT, "pay", String.format("method: %s, order_id: %s, error_code: %s, message: %s", new Object[]{this.f5341a.mo1504d(), this.f5341a.mo1501a(), i + "", str2}));
        if (i == 7) {
            this.f5342b.mo1507a(bundle.getString(PaymentManager.PAYMENT_KEY_PAYMENT_RESULT));
        } else if (i == 4) {
            this.f5342b.mo1505a();
        } else {
            this.f5342b.mo1506a(i, String.format(this.f5343c.getString(C0247i.general__shared__mi_pay_error), new Object[]{Integer.valueOf(i)}));
        }
    }
}
