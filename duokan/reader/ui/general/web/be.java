package com.duokan.reader.ui.general.web;

import android.text.TextUtils;

import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.domain.store.h;
import com.duokan.reader.ui.store.g;

class be implements h {
    final /* synthetic */ bd a;

    be(bd bdVar) {
        this.a = bdVar;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        DkStoreBookDetail dkStoreBookDetail = (DkStoreBookDetail) dkStoreItem;
        ((ReaderFeature) this.a.b.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new g(this.a.b.getContext(), dkStoreBookDetail.getBook().getTitle(), dkStoreBookDetail.getToc()), null);
    }

    public void onFetchBookDetailError(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.duokan.reader.ui.general.be.a(this.a.b.getContext(), (CharSequence) str, 1).show();
        }
    }
}
