package com.duokan.reader.ui.general.web;

import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.store.C0466h;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.ui.store.bb;

class cd implements C0466h {
    /* renamed from: a */
    final /* synthetic */ cc f7666a;

    cd(cc ccVar) {
        this.f7666a = ccVar;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        ((ReaderFeature) this.f7666a.f7665c.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new bb(this.f7666a.f7665c.getContext(), (DkStoreFictionDetail) dkStoreItem, this.f7666a.f7664b), null);
    }

    public void onFetchBookDetailError(String str) {
        this.f7666a.f7665c.doShowToast(str);
    }
}
