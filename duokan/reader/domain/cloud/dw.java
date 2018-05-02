package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.a.a;
import com.duokan.reader.domain.account.u;

class dw implements u {
    final /* synthetic */ String[] a;
    final /* synthetic */ a b;
    final /* synthetic */ DkUserPurchasedFictionsManager c;

    dw(DkUserPurchasedFictionsManager dkUserPurchasedFictionsManager, String[] strArr, a aVar) {
        this.c = dkUserPurchasedFictionsManager;
        this.a = strArr;
        this.b = aVar;
    }

    public void onQueryAccountOk(com.duokan.reader.domain.account.a aVar) {
        this.c.a(new dx(this));
    }

    public void onQueryAccountError(com.duokan.reader.domain.account.a aVar, String str) {
        this.b.a(-1, str);
    }
}
