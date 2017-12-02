package com.duokan.reader.ui.general;

import android.text.TextUtils;

import com.duokan.core.ui.j;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.k;
import com.duokan.reader.domain.cloud.DkCloudPurchasedBook;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.domain.store.h;
import com.duokan.reader.ui.bookshelf.ay;

class hw implements h {
    final /* synthetic */ k a;
    final /* synthetic */ j b;
    final /* synthetic */ DkCloudPurchasedBook c;
    final /* synthetic */ hs d;

    hw(hs hsVar, k kVar, j jVar, DkCloudPurchasedBook dkCloudPurchasedBook) {
        this.d = hsVar;
        this.a = kVar;
        this.b = jVar;
        this.c = dkCloudPurchasedBook;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        if (!((Boolean) this.a.a()).booleanValue()) {
            this.b.dismiss();
            DkStoreBookDetail dkStoreBookDetail = (DkStoreBookDetail) dkStoreItem;
            ay.a(DkApp.get().getTopActivity(), dkStoreBookDetail.getEpubSize(), new hx(this, dkStoreBookDetail));
        }
    }

    public void onFetchBookDetailError(String str) {
        if (!((Boolean) this.a.a()).booleanValue()) {
            this.b.dismiss();
            if (!TextUtils.isEmpty(str)) {
                be.a(DkApp.get().getTopActivity(), (CharSequence) str, 1).show();
            }
        }
    }
}
