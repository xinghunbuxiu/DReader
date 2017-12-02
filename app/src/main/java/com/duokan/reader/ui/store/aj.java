package com.duokan.reader.ui.store;

import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.ej;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.domain.store.h;

class aj implements h {
    final /* synthetic */ String a;
    final /* synthetic */ h b;
    final /* synthetic */ o c;

    aj(o oVar, String str, h hVar) {
        this.c = oVar;
        this.a = str;
        this.b = hVar;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        DkStoreFictionDetail dkStoreFictionDetail = (DkStoreFictionDetail) dkStoreItem;
        if (DkUserPurchasedFictionsManager.a().c(this.a)) {
            DkUserPurchasedFictionsManager.a().a(this.a, new ak(this, dkStoreFictionDetail));
        } else {
            a(dkStoreFictionDetail);
        }
    }

    public void onFetchBookDetailError(String str) {
        this.b.onFetchBookDetailError(str);
    }

    private void a(DkStoreFictionDetail dkStoreFictionDetail) {
        c b = this.c.f.b(this.a);
        if (b instanceof ej) {
            ((ej) b).c(dkStoreFictionDetail);
            b.aL();
        }
        o.a(dkStoreFictionDetail);
        this.b.onFetchBookDetailOk(dkStoreFictionDetail);
    }
}
