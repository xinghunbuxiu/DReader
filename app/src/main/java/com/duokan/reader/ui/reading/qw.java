package com.duokan.reader.ui.reading;

import com.duokan.core.sys.t;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.domain.store.h;

class qw implements h {
    final /* synthetic */ Runnable a;
    final /* synthetic */ qh b;

    qw(qh qhVar, Runnable runnable) {
        this.b = qhVar;
        this.a = runnable;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        if (!this.b.q) {
            this.b.a((DkStoreBookDetail) dkStoreItem);
            t.b(this.a);
        }
    }

    public void onFetchBookDetailError(String str) {
        this.b.a(null);
        t.b(this.a);
    }
}
