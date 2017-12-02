package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.duokan.DkStoreBookPrice;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.payment.q;
import com.duokan.reader.ui.store.bj;

class fw implements bj {
    final /* synthetic */ a a;
    final /* synthetic */ DkStoreBookPrice b;
    final /* synthetic */ String c;
    final /* synthetic */ fv d;

    fw(fv fvVar, a aVar, DkStoreBookPrice dkStoreBookPrice, String str) {
        this.d = fvVar;
        this.a = aVar;
        this.b = dkStoreBookPrice;
        this.c = str;
    }

    public void a(q qVar) {
        new fx(this, qVar.a()).open();
    }
}
