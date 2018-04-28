package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.store.C0466h;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.store.C1494g;

class bd implements C0466h {
    /* renamed from: a */
    final /* synthetic */ bc f7620a;

    bd(bc bcVar) {
        this.f7620a = bcVar;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        DkStoreBookDetail dkStoreBookDetail = (DkStoreBookDetail) dkStoreItem;
        ((ReaderFeature) this.f7620a.f7619b.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new C1494g(this.f7620a.f7619b.getContext(), dkStoreBookDetail.getBook().getTitle(), dkStoreBookDetail.getToc()), null);
    }

    public void onFetchBookDetailError(String str) {
        if (!TextUtils.isEmpty(str)) {
            be.m10287a(this.f7620a.f7619b.getContext(), (CharSequence) str, 1).show();
        }
    }
}
