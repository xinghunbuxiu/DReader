package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.a.a;
import com.duokan.reader.domain.account.u;

class de implements u {
    final /* synthetic */ String a;
    final /* synthetic */ a b;
    final /* synthetic */ DkUserPurchasedFictionsManager c;

    de(DkUserPurchasedFictionsManager dkUserPurchasedFictionsManager, String str, a aVar) {
        this.c = dkUserPurchasedFictionsManager;
        this.a = str;
        this.b = aVar;
    }

    public void onQueryAccountOk(com.duokan.reader.domain.account.a aVar) {
        this.c.a(new df(this));
    }

    public void onQueryAccountError(com.duokan.reader.domain.account.a aVar, String str) {
        this.b.a(-1, str);
    }
}
