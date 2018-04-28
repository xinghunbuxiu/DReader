package com.duokan.reader.domain.store;

import com.duokan.reader.domain.payment.C1089s;
import com.duokan.reader.domain.payment.PaymentResult;

public interface DkStoreCallback {

    public enum AbortPayErrorCode {
        NORMAL,
        REPEAT_PAY
    }

    /* renamed from: a */
    void mo1163a(C1089s c1089s, PaymentResult paymentResult);

    /* renamed from: a */
    void mo1164a(C1089s c1089s, String str);

    /* renamed from: a */
    void mo1165a(C1089s c1089s, String str, AbortPayErrorCode abortPayErrorCode);
}
