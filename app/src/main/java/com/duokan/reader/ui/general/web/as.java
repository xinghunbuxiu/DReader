package com.duokan.reader.ui.general.web;

import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.domain.store.h;
import com.duokan.reader.ui.store.bb;

class as implements h {
    final /* synthetic */ ar a;

    as(ar arVar) {
        this.a = arVar;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        ((ReaderFeature) this.a.c.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new bb(this.a.c.getContext(), (DkStoreFictionDetail) dkStoreItem, this.a.b), null);
    }

    public void onFetchBookDetailError(String str) {
        this.a.c.doShowToast(str);
    }
}
