package com.duokan.reader.domain.store;

import com.duokan.reader.domain.payment.PaymentResult;
import com.duokan.reader.domain.payment.s;

public interface DkStoreCallback {

    public enum AbortPayErrorCode {
        NORMAL,
        REPEAT_PAY
    }

    void a(s sVar, PaymentResult paymentResult);

    void a(s sVar, String str);

    void a(s sVar, String str, AbortPayErrorCode abortPayErrorCode);
}
