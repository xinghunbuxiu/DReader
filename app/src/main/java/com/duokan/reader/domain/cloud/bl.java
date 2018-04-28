package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;

class bl implements C0666x {
    /* renamed from: a */
    final /* synthetic */ DkCloudPurchasedBook f3761a;
    /* renamed from: b */
    final /* synthetic */ DkUserPurchasedBooksManager f3762b;

    bl(DkUserPurchasedBooksManager dkUserPurchasedBooksManager, DkCloudPurchasedBook dkCloudPurchasedBook) {
        this.f3762b = dkUserPurchasedBooksManager;
        this.f3761a = dkCloudPurchasedBook;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        if (this.f3761a.markGifted()) {
            this.f3762b.m5053a(new bm(this));
        }
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
    }
}
