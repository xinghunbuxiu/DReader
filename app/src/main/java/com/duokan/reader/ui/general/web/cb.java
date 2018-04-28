package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.store.C0466h;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.ui.general.ja;

class cb implements C0466h {
    /* renamed from: a */
    final /* synthetic */ ja f7660a;
    /* renamed from: b */
    final /* synthetic */ C0466h f7661b;
    /* renamed from: c */
    final /* synthetic */ StorePageController f7662c;

    cb(StorePageController storePageController, ja jaVar, C0466h c0466h) {
        this.f7662c = storePageController;
        this.f7660a = jaVar;
        this.f7661b = c0466h;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        this.f7662c.mFictionCache = (DkStoreFictionDetail) dkStoreItem;
        if (this.f7660a != null) {
            this.f7660a.dismiss();
        }
        this.f7661b.onFetchBookDetailOk(dkStoreItem);
    }

    public void onFetchBookDetailError(String str) {
        if (this.f7660a != null) {
            this.f7660a.dismiss();
        }
        this.f7661b.onFetchBookDetailError(str);
    }
}
