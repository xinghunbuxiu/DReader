package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.u;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.ui.general.jq;

class fr implements u {
    final /* synthetic */ DkStoreBookDetail a;
    final /* synthetic */ gd b;
    final /* synthetic */ jq c;
    final /* synthetic */ fp d;

    fr(fp fpVar, DkStoreBookDetail dkStoreBookDetail, gd gdVar, jq jqVar) {
        this.d = fpVar;
        this.a = dkStoreBookDetail;
        this.b = gdVar;
        this.c = jqVar;
    }

    public void onQueryAccountOk(a aVar) {
        this.d.a(this.a, this.b, this.c);
    }

    public void onQueryAccountError(a aVar, String str) {
    }
}
