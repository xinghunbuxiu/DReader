package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.a.a;
import com.duokan.reader.common.webservices.duokan.DkStoreBookSourceType;
import com.duokan.reader.domain.account.ab;

class bz implements a {
    final /* synthetic */ String a;
    final /* synthetic */ DkUserPurchasedBooksManager b;

    bz(DkUserPurchasedBooksManager dkUserPurchasedBooksManager, String str) {
        this.b = dkUserPurchasedBooksManager;
        this.a = str;
    }

    public void a(Void voidR) {
        ab e = DkUserPurchasedBooksManager.h();
        DkCloudPurchasedBook a = this.b.h.a(this.a);
        if (a != null) {
            if ((a.getBookSourceType() == DkStoreBookSourceType.GIFT || a.getBookSourceType() == DkStoreBookSourceType.GIFTED) && e.c()) {
                new ca(this, e).open();
            }
        }
    }

    public void a(int i, String str) {
    }
}
