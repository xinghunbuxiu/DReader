package com.duokan.reader.ui.general.web;

import android.text.TextUtils;

import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.domain.store.h;
import com.duokan.reader.ui.account.ay;
import com.duokan.reader.ui.general.be;

class ib implements h {
    final /* synthetic */ ia a;

    ib(ia iaVar) {
        this.a = iaVar;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        DkStoreBookDetail dkStoreBookDetail = (DkStoreBookDetail) dkStoreItem;
        if (this.a.a.b.b.mShareEntranceContext == null) {
            this.a.a.b.b.mShareEntranceContext = new ay(this.a.a.b.b);
        }
        this.a.a.b.b.mShareEntranceContext.a(this.a.a.b.b.getContext(), dkStoreBookDetail.getWebUrl(), dkStoreBookDetail.getBook(), dkStoreBookDetail.getSummary(), null);
    }

    public void onFetchBookDetailError(String str) {
        if (!TextUtils.isEmpty(str)) {
            be.a(this.a.a.b.b.getContext(), (CharSequence) str, 1).show();
        }
    }
}
