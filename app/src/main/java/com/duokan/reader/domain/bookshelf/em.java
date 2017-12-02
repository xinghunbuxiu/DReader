package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.ah;
import com.duokan.core.sys.t;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.domain.store.h;

class em implements h {
    final /* synthetic */ el a;

    em(el elVar) {
        this.a = elVar;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        ah.b(new en(this, (DkStoreFictionDetail) dkStoreItem));
    }

    public void onFetchBookDetailError(String str) {
        t.a(this.a.b);
    }
}
