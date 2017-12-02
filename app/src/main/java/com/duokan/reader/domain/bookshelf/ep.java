package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.ag;
import com.duokan.core.sys.ah;
import com.duokan.core.sys.t;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.domain.store.h;

class ep implements h {
    final /* synthetic */ Runnable a;
    final /* synthetic */ ag b;
    final /* synthetic */ Runnable c;
    final /* synthetic */ ej d;

    ep(ej ejVar, Runnable runnable, ag agVar, Runnable runnable2) {
        this.d = ejVar;
        this.a = runnable;
        this.b = agVar;
        this.c = runnable2;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        ah.b(new eq(this, (DkStoreFictionDetail) dkStoreItem));
    }

    public void onFetchBookDetailError(String str) {
        t.a(this.c);
    }
}
