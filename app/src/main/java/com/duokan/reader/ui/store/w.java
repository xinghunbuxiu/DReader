package com.duokan.reader.ui.store;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.u;
import com.duokan.reader.domain.payment.PaymentManager;
import com.duokan.reader.domain.store.DkStoreCallback;
import com.duokan.reader.domain.store.DkStoreCallback.AbortPayErrorCode;
import com.duokan.reader.domain.store.m;

class w implements u {
    final /* synthetic */ m a;
    final /* synthetic */ String b;
    final /* synthetic */ DkStoreCallback c;
    final /* synthetic */ o d;

    w(o oVar, m mVar, String str, DkStoreCallback dkStoreCallback) {
        this.d = oVar;
        this.a = mVar;
        this.b = str;
        this.c = dkStoreCallback;
    }

    public void onQueryAccountOk(a aVar) {
        PaymentManager.a().a(aVar, this.a, this.b, this.c);
    }

    public void onQueryAccountError(a aVar, String str) {
        this.c.a(this.a, str, AbortPayErrorCode.NORMAL);
    }
}
