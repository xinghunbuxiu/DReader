package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.cloud.fp;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.domain.store.h;

class bb implements h {
    final /* synthetic */ ba a;

    bb(ba baVar) {
        this.a = baVar;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        fp.a().a((DkStoreBookDetail) dkStoreItem, new bc(this));
    }

    public void onFetchBookDetailError(String str) {
        this.a.b.doShowToast(str);
    }
}
