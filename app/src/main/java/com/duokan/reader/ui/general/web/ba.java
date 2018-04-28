package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.cloud.ex;
import com.duokan.reader.domain.store.C0466h;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreItem;

class ba implements C0466h {
    /* renamed from: a */
    final /* synthetic */ az f7616a;

    ba(az azVar) {
        this.f7616a = azVar;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        ex.m5516a().m5522a((DkStoreBookDetail) dkStoreItem, new bb(this));
    }

    public void onFetchBookDetailError(String str) {
        this.f7616a.f7614b.doShowToast(str);
    }
}
