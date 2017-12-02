package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.domain.store.h;
import com.duokan.reader.ui.general.jq;

class az implements h {
    final /* synthetic */ jq a;
    final /* synthetic */ h b;
    final /* synthetic */ StorePageController c;

    az(StorePageController storePageController, jq jqVar, h hVar) {
        this.c = storePageController;
        this.a = jqVar;
        this.b = hVar;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        this.c.mBookCache = (DkStoreBookDetail) dkStoreItem;
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
