package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.a.a;
import com.duokan.reader.domain.account.u;

class cj implements u {
    final /* synthetic */ boolean a;
    final /* synthetic */ boolean b;
    final /* synthetic */ a c;
    final /* synthetic */ DkUserPurchasedBooksManager d;

    cj(DkUserPurchasedBooksManager dkUserPurchasedBooksManager, boolean z, boolean z2, a aVar) {
        this.d = dkUserPurchasedBooksManager;
        this.a = z;
        this.b = z2;
        this.c = aVar;
    }

    public void onQueryAccountOk(com.duokan.reader.domain.account.a aVar) {
        this.d.b(new ck(this));
    }

    public void onQueryAccountError(com.duokan.reader.domain.account.a aVar, String str) {
        this.c.a(-1, "");
    }
}
