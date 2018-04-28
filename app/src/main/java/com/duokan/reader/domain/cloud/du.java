package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.cache.ab;
import java.util.Collection;

class du implements ab {
    /* renamed from: a */
    final /* synthetic */ dt f3892a;

    du(dt dtVar) {
        this.f3892a = dtVar;
    }

    /* renamed from: a */
    public void mo1155a(int i) {
        if (i < 2) {
            this.f3892a.clearItems();
            this.f3892a.updateInfo(null);
        }
        if (i < 3) {
            this.f3892a.replaceWithItems(this.f3892a.queryItems());
        }
        if (i < 5) {
            C0844do c0844do = new C0844do(this.f3892a.a);
            c0844do.m5451a();
            Collection<DkCloudPurchasedFiction> queryItems = c0844do.queryItems();
            for (DkCloudPurchasedFiction hidden : queryItems) {
                hidden.setHidden(true);
            }
            this.f3892a.insertItems((Collection) queryItems);
        }
    }
}
