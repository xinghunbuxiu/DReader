package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.store.C0466h;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.domain.store.DkStoreItem;

class ja implements C0466h {
    /* renamed from: a */
    final /* synthetic */ iz f8029a;

    ja(iz izVar) {
        this.f8029a = izVar;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        Object a = ai.m3980a().m3874a((DkStoreFictionDetail) dkStoreItem);
        a.m4235j(this.f8029a.f8025b);
        this.f8029a.f8026c.mo975a(a);
        synchronized (this.f8029a.f8026c) {
            this.f8029a.f8026c.notify();
        }
    }

    public void onFetchBookDetailError(String str) {
        this.f8029a.f8027d.f8022b.f7581b.doShowToast(str);
        synchronized (this.f8029a.f8026c) {
            this.f8029a.f8026c.notify();
        }
    }
}
