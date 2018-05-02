package com.duokan.reader.domain.payment;

import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.store.DkStoreCallback;
import com.duokan.reader.domain.store.DkStoreCallback.AbortPayErrorCode;

/* renamed from: com.duokan.reader.domain.payment.k */
class C1098k implements C1097r {
    /* renamed from: a */
    final /* synthetic */ C0672a f5350a;
    /* renamed from: b */
    final /* synthetic */ String f5351b;
    /* renamed from: c */
    final /* synthetic */ DkStoreCallback f5352c;
    /* renamed from: d */
    final /* synthetic */ PaymentManager f5353d;

    C1098k(PaymentManager paymentManager, C0672a c0672a, String str, DkStoreCallback dkStoreCallback) {
        this.f5353d = paymentManager;
        this.f5350a = c0672a;
        this.f5351b = str;
        this.f5352c = dkStoreCallback;
    }

    /* renamed from: a */
    public void mo1508a(C1085q c1085q, C1089s c1089s, String str) {
        C1089s c1089s2 = c1089s;
        String str2 = str;
        this.f5353d.m8339a(this.f5350a, this.f5351b, c1089s2, str2, this.f5353d.m8334a(this.f5350a.mo832b(), c1089s, str, this.f5351b), new C1099l(this, c1089s));
    }

    /* renamed from: b */
    public void mo1509b(C1085q c1085q, C1089s c1089s, String str) {
        this.f5352c.mo1165a(c1089s, str, AbortPayErrorCode.NORMAL);
    }
}
