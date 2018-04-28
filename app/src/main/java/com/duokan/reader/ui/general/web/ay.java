package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.store.C0466h;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.ui.general.ja;

class ay implements C0466h {
    /* renamed from: a */
    final /* synthetic */ ja f7610a;
    /* renamed from: b */
    final /* synthetic */ C0466h f7611b;
    /* renamed from: c */
    final /* synthetic */ StorePageController f7612c;

    ay(StorePageController storePageController, ja jaVar, C0466h c0466h) {
        this.f7612c = storePageController;
        this.f7610a = jaVar;
        this.f7611b = c0466h;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        this.f7612c.mBookCache = (DkStoreBookDetail) dkStoreItem;
        if (this.f7610a != null) {
            this.f7610a.dismiss();
        }
        this.f7611b.onFetchBookDetailOk(dkStoreItem);
    }

    public void onFetchBookDetailError(String str) {
        if (this.f7610a != null) {
            this.f7610a.dismiss();
        }
        this.f7611b.onFetchBookDetailError(str);
    }
}
