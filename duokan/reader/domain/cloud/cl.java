package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.a.a;
import com.duokan.reader.domain.account.u;

class cl implements u {
    final /* synthetic */ boolean a;
    final /* synthetic */ a b;
    final /* synthetic */ boolean c;
    final /* synthetic */ DkUserPurchasedBooksManager d;

    cl(DkUserPurchasedBooksManager dkUserPurchasedBooksManager, boolean z, a aVar, boolean z2) {
        this.d = dkUserPurchasedBooksManager;
        this.a = z;
        this.b = aVar;
        this.c = z2;
    }

    public void onQueryAccountOk(com.duokan.reader.domain.account.a aVar) {
        this.d.a(new cm(this));
    }

    public void onQueryAccountError(com.duokan.reader.domain.account.a aVar, String str) {
        this.b.a(-1, str);
    }
}
