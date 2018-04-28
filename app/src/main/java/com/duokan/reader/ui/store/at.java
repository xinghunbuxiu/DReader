package com.duokan.reader.ui.store;

import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.domain.store.DkStoreItem;

class at implements Runnable {
    /* renamed from: a */
    final /* synthetic */ DkStoreItem f11328a;
    /* renamed from: b */
    final /* synthetic */ as f11329b;

    at(as asVar, DkStoreItem dkStoreItem) {
        this.f11329b = asVar;
        this.f11328a = dkStoreItem;
    }

    public void run() {
        DkStoreFictionDetail dkStoreFictionDetail = (DkStoreFictionDetail) this.f11328a;
        this.f11329b.f11326a.dismiss();
        aq.m15261b(this.f11329b.f11327b.f11323a, dkStoreFictionDetail, false, (String[]) this.f11329b.f11327b.f11325c.f11336d.toArray(new String[0]), this.f11329b.f11327b.f11325c.m15266a(), new au(this));
    }
}
