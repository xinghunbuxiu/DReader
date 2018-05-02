package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.u;

class bw implements u {
    final /* synthetic */ DkCloudPurchasedBook a;
    final /* synthetic */ DkUserPurchasedBooksManager b;

    bw(DkUserPurchasedBooksManager dkUserPurchasedBooksManager, DkCloudPurchasedBook dkCloudPurchasedBook) {
        this.b = dkUserPurchasedBooksManager;
        this.a = dkCloudPurchasedBook;
    }

    public void onQueryAccountOk(a aVar) {
        if (this.a.markGifted()) {
            this.b.a(new bx(this));
        }
    }

    public void onQueryAccountError(a aVar, String str) {
    }
}
