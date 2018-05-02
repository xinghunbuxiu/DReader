package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.u;

class q implements u {
    final /* synthetic */ String a;
    final /* synthetic */ ao b;
    final /* synthetic */ DkCloudStorage c;

    q(DkCloudStorage dkCloudStorage, String str, ao aoVar) {
        this.c = dkCloudStorage;
        this.a = str;
        this.b = aoVar;
    }

    public void onQueryAccountOk(a aVar) {
        new r(this, aVar).open();
    }

    public void onQueryAccountError(a aVar, String str) {
        this.b.a(this.a, str);
    }
}
