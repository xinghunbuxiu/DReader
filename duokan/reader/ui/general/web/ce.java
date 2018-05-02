package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.domain.store.h;
import com.duokan.reader.ui.general.jq;

class ce implements h {
    final /* synthetic */ jq a;
    final /* synthetic */ h b;
    final /* synthetic */ StorePageController c;

    ce(StorePageController storePageController, jq jqVar, h hVar) {
        this.c = storePageController;
        this.a = jqVar;
        this.b = hVar;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        this.c.mFictionCache = (DkStoreFictionDetail) dkStoreItem;
        if (this.a != null) {
            this.a.dismiss();
        }
        this.b.onFetchBookDetailOk(dkStoreItem);
    }

    public void onFetchBookDetailError(String str) {
        if (this.a != null) {
            this.a.dismiss();
        }
        this.b.onFetchBookDetailError(str);
    }
}
