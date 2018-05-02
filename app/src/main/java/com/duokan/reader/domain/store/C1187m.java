package com.duokan.reader.domain.store;

import android.text.TextUtils;
import com.duokan.reader.common.webservices.duokan.DkStoreBookPrice;
import com.duokan.reader.common.webservices.duokan.DkStoreOrderInfo;
import com.duokan.reader.domain.payment.C1089s;

/* renamed from: com.duokan.reader.domain.store.m */
public class C1187m extends C1089s {
    /* renamed from: a */
    protected final DkStoreOrderInfo f5667a;
    /* renamed from: b */
    protected final DkStoreBookPrice[] f5668b;

    public C1187m(DkStoreOrderInfo dkStoreOrderInfo, DkStoreBookPrice... dkStoreBookPriceArr) {
        this.f5667a = dkStoreOrderInfo;
        this.f5668b = dkStoreBookPriceArr;
    }

    /* renamed from: e */
    public int m8719e() {
        return this.f5667a.mPrice;
    }

    /* renamed from: f */
    public int m8720f() {
        int i = 0;
        DkStoreBookPrice[] dkStoreBookPriceArr = this.f5668b;
        int i2 = 0;
        while (i < dkStoreBookPriceArr.length) {
            i2 += dkStoreBookPriceArr[i].mNewPrice;
            i++;
        }
        return i2;
    }

    /* renamed from: g */
    public boolean m8721g() {
        return TextUtils.isEmpty(this.f5667a.mBookUuid);
    }

    /* renamed from: h */
    public DkStoreBookPrice[] m8722h() {
        return this.f5668b;
    }

    /* renamed from: i */
    public int m8723i() {
        return this.f5667a.mDiscountName.length;
    }

    /* renamed from: a */
    public String m8714a(int i) {
        return this.f5667a.mDiscountName[i];
    }

    /* renamed from: b */
    public float m8715b(int i) {
        return this.f5667a.mDiscountValue[i];
    }

    /* renamed from: a */
    public String mo1501a() {
        return this.f5667a.mPaymentId;
    }

    /* renamed from: b */
    public String mo1502b() {
        return this.f5667a.mPaymentEnvelop;
    }

    /* renamed from: c */
    public String mo1503c() {
        return this.f5667a.mPaymentSenderSign;
    }

    /* renamed from: d */
    public String mo1504d() {
        return this.f5667a.mPaymentMothodName;
    }
}
