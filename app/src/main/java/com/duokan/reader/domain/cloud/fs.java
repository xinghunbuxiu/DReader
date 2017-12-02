package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.u;

class fs implements u {
    final /* synthetic */ DkCloudRedeemFund a;
    final /* synthetic */ String b;
    final /* synthetic */ ge c;
    final /* synthetic */ fp d;

    fs(fp fpVar, DkCloudRedeemFund dkCloudRedeemFund, String str, ge geVar) {
        this.d = fpVar;
        this.a = dkCloudRedeemFund;
        this.b = str;
        this.c = geVar;
    }

    public void onQueryAccountOk(a aVar) {
        new ft(this, aVar, aVar.b()).open();
    }

    public void onQueryAccountError(a aVar, String str) {
        this.c.a(str);
    }
}
