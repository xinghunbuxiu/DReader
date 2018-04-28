package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.UThread;
import com.duokan.core.sys.ag;
import com.duokan.core.sys.ah;
import com.duokan.reader.domain.store.C0466h;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.domain.store.DkStoreItem;

class ek implements C0466h {
    /* renamed from: a */
    final /* synthetic */ Runnable f3105a;
    /* renamed from: b */
    final /* synthetic */ ag f3106b;
    /* renamed from: c */
    final /* synthetic */ Runnable f3107c;
    /* renamed from: d */
    final /* synthetic */ ee f3108d;

    ek(ee eeVar, Runnable runnable, ag agVar, Runnable runnable2) {
        this.f3108d = eeVar;
        this.f3105a = runnable;
        this.f3106b = agVar;
        this.f3107c = runnable2;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        ah.m871b(new el(this, (DkStoreFictionDetail) dkStoreItem));
    }

    public void onFetchBookDetailError(String str) {
        UThread.runOnThread(this.f3107c);
    }
}
