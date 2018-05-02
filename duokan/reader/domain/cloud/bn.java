package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.a.a;
import com.duokan.reader.domain.account.u;

class bn implements u {
    final /* synthetic */ String[] a;
    final /* synthetic */ a b;
    final /* synthetic */ DkUserPurchasedBooksManager c;

    bn(DkUserPurchasedBooksManager dkUserPurchasedBooksManager, String[] strArr, a aVar) {
        this.c = dkUserPurchasedBooksManager;
        this.a = strArr;
        this.b = aVar;
    }

    public void onQueryAccountOk(com.duokan.reader.domain.account.a aVar) {
        this.c.a(new bo(this));
    }

    public void onQueryAccountError(com.duokan.reader.domain.account.a aVar, String str) {
        this.b.a(-1, str);
    }
}
