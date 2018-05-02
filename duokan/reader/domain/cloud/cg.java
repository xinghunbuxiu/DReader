package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.a.a;
import com.duokan.reader.domain.account.u;

class cg implements u {
    final /* synthetic */ String a;
    final /* synthetic */ a b;
    final /* synthetic */ DkUserPurchasedBooksManager c;

    cg(DkUserPurchasedBooksManager dkUserPurchasedBooksManager, String str, a aVar) {
        this.c = dkUserPurchasedBooksManager;
        this.a = str;
        this.b = aVar;
    }

    public void onQueryAccountOk(com.duokan.reader.domain.account.a aVar) {
        this.c.a(new ch(this));
    }

    public void onQueryAccountError(com.duokan.reader.domain.account.a aVar, String str) {
        this.b.a(-1, "");
    }
}
