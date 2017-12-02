package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.cache.ab;

import java.util.Collection;

class ej implements ab {
    final /* synthetic */ ei a;

    ej(ei eiVar) {
        this.a = eiVar;
    }

    public void a(int i) {
        if (i < 2) {
            this.a.clearItems();
            this.a.updateInfo(null);
        }
        if (i < 3) {
            this.a.replaceWithItems(this.a.queryItems());
        }
        if (i < 5) {
            ed edVar = new ed(this.a.a);
            edVar.a();
            Collection<DkCloudPurchasedFiction> queryItems = edVar.queryItems();
            for (DkCloudPurchasedFiction hidden : queryItems) {
                hidden.setHidden(true);
            }
            this.a.insertItems((Collection) queryItems);
        }
    }
}
