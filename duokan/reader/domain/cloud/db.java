package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.a.a;
import com.duokan.reader.domain.account.u;

import java.util.List;

class db implements u {
    final /* synthetic */ String a;
    final /* synthetic */ List b;
    final /* synthetic */ a c;
    final /* synthetic */ DkUserPurchasedFictionsManager d;

    db(DkUserPurchasedFictionsManager dkUserPurchasedFictionsManager, String str, List list, a aVar) {
        this.d = dkUserPurchasedFictionsManager;
        this.a = str;
        this.b = list;
        this.c = aVar;
    }

    public void onQueryAccountOk(com.duokan.reader.domain.account.a aVar) {
        this.d.a(new dc(this));
    }

    public void onQueryAccountError(com.duokan.reader.domain.account.a aVar, String str) {
        this.c.a(-1, str);
    }
}
