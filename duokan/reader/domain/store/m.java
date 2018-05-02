package com.duokan.reader.domain.store;

import android.text.TextUtils;

import com.duokan.reader.common.webservices.duokan.DkStoreBookPrice;
import com.duokan.reader.common.webservices.duokan.DkStoreOrderInfo;
import com.duokan.reader.domain.payment.s;

public class m extends s {
    protected final DkStoreOrderInfo a;
    protected final DkStoreBookPrice[] b;

    public m(DkStoreOrderInfo dkStoreOrderInfo, DkStoreBookPrice... dkStoreBookPriceArr) {
        this.a = dkStoreOrderInfo;
        this.b = dkStoreBookPriceArr;
    }

    public int e() {
        return this.a.mPrice;
    }

    public int f() {
        int i = 0;
        DkStoreBookPrice[] dkStoreBookPriceArr = this.b;
        int i2 = 0;
        while (i < dkStoreBookPriceArr.length) {
            i2 += dkStoreBookPriceArr[i].mNewPrice;
            i++;
        }
        return i2;
    }

    public boolean g() {
        return TextUtils.isEmpty(this.a.mBookUuid);
    }

    public DkStoreBookPrice[] h() {
        return this.b;
    }

    public int i() {
        return this.a.mDiscountName.length;
    }

    public String a(int i) {
        return this.a.mDiscountName[i];
    }

    public float b(int i) {
        return this.a.mDiscountValue[i];
    }

    public String a() {
        return this.a.mPaymentId;
    }

    public String b() {
        return this.a.mPaymentEnvelop;
    }

    public String c() {
        return this.a.mPaymentSenderSign;
    }

    public String d() {
        return this.a.mPaymentMothodName;
    }
}
