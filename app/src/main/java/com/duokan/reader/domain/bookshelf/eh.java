package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.UThread;
import com.duokan.core.sys.ah;
import com.duokan.reader.domain.store.C0466h;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.domain.store.DkStoreItem;

class eh implements C0466h {
    /* renamed from: a */
    final /* synthetic */ eg f3101a;

    eh(eg egVar) {
        this.f3101a = egVar;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        ah.m871b(new ei(this, (DkStoreFictionDetail) dkStoreItem));
    }

    public void onFetchBookDetailError(String str) {
        UThread.runOnThread(this.f3101a.f3099b);
    }
}
