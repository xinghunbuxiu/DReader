package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.a.a;
import com.duokan.reader.domain.account.u;

class dp implements u {
    final /* synthetic */ boolean a;
    final /* synthetic */ a b;
    final /* synthetic */ boolean c;
    final /* synthetic */ DkUserPurchasedFictionsManager d;

    dp(DkUserPurchasedFictionsManager dkUserPurchasedFictionsManager, boolean z, a aVar, boolean z2) {
        this.d = dkUserPurchasedFictionsManager;
        this.a = z;
        this.b = aVar;
        this.c = z2;
    }

    public void onQueryAccountOk(com.duokan.reader.domain.account.a aVar) {
        this.d.a(new dq(this));
    }

    public void onQueryAccountError(com.duokan.reader.domain.account.a aVar, String str) {
        this.b.a(-1, "");
    }
}
