package com.duokan.reader.ui.store;

import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.domain.store.DkStoreItem;

class at implements Runnable {
    final /* synthetic */ DkStoreItem a;
    final /* synthetic */ as b;

    at(as asVar, DkStoreItem dkStoreItem) {
        this.b = asVar;
        this.a = dkStoreItem;
    }

    public void run() {
        DkStoreFictionDetail dkStoreFictionDetail = (DkStoreFictionDetail) this.a;
        this.b.a.dismiss();
        aq.b(this.b.b.a, dkStoreFictionDetail, false, (String[]) this.b.b.c.d.toArray(new String[0]), this.b.b.c.a(), new au(this));
    }
}
