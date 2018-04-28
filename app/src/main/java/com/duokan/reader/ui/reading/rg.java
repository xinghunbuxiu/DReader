package com.duokan.reader.ui.reading;

import com.duokan.core.sys.UThread;
import com.duokan.reader.domain.store.C0466h;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreItem;

class rg implements C0466h {
    /* renamed from: a */
    final /* synthetic */ Runnable f10890a;
    /* renamed from: b */
    final /* synthetic */ qr f10891b;

    rg(qr qrVar, Runnable runnable) {
        this.f10891b = qrVar;
        this.f10890a = runnable;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        if (!this.f10891b.f9293q) {
            this.f10891b.m12789a((DkStoreBookDetail) dkStoreItem);
            UThread.post(this.f10890a);
        }
    }

    public void onFetchBookDetailError(String str) {
        this.f10891b.m12791a(null);
        UThread.post(this.f10890a);
    }
}
