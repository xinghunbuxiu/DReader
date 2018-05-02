package com.duokan.reader.ui.store;

import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.payment.PaymentManager;
import com.duokan.reader.domain.store.C1187m;
import com.duokan.reader.domain.store.DkStoreCallback;
import com.duokan.reader.domain.store.DkStoreCallback.AbortPayErrorCode;

/* renamed from: com.duokan.reader.ui.store.w */
class C1510w implements C0666x {
    /* renamed from: a */
    final /* synthetic */ C1187m f11481a;
    /* renamed from: b */
    final /* synthetic */ String f11482b;
    /* renamed from: c */
    final /* synthetic */ DkStoreCallback f11483c;
    /* renamed from: d */
    final /* synthetic */ C1502o f11484d;

    C1510w(C1502o c1502o, C1187m c1187m, String str, DkStoreCallback dkStoreCallback) {
        this.f11484d = c1502o;
        this.f11481a = c1187m;
        this.f11482b = str;
        this.f11483c = dkStoreCallback;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        PaymentManager.m8331a().m8351a(c0672a, this.f11481a, this.f11482b, this.f11483c);
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f11483c.mo1165a(this.f11481a, str, AbortPayErrorCode.NORMAL);
    }
}
