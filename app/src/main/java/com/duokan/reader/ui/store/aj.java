package com.duokan.reader.ui.store;

import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ee;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.domain.store.C0466h;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.domain.store.DkStoreItem;

class aj implements C0466h {
    /* renamed from: a */
    final /* synthetic */ String f11318a;
    /* renamed from: b */
    final /* synthetic */ C0466h f11319b;
    /* renamed from: c */
    final /* synthetic */ C1502o f11320c;

    aj(C1502o c1502o, String str, C0466h c0466h) {
        this.f11320c = c1502o;
        this.f11318a = str;
        this.f11319b = c0466h;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        DkStoreFictionDetail dkStoreFictionDetail = (DkStoreFictionDetail) dkStoreItem;
        if (DkUserPurchasedFictionsManager.m5072a().m5108c(this.f11318a)) {
            DkUserPurchasedFictionsManager.m5072a().m5097a(this.f11318a, new ak(this, dkStoreFictionDetail));
        } else {
            m15248a(dkStoreFictionDetail);
        }
    }

    public void onFetchBookDetailError(String str) {
        this.f11319b.onFetchBookDetailError(str);
    }

    /* renamed from: a */
    private void m15248a(DkStoreFictionDetail dkStoreFictionDetail) {
        C0800c b = this.f11320c.f11461f.m3906b(this.f11318a);
        if (b instanceof ee) {
            ((ee) b).m4418c(dkStoreFictionDetail);
            b.aN();
        }
        C1502o.m15413a(dkStoreFictionDetail);
        this.f11319b.onFetchBookDetailOk(dkStoreFictionDetail);
    }
}
