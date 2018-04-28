package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.cloud.DkCloudPurchasedBook;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.ui.store.al;

class kk implements al {
    /* renamed from: a */
    final /* synthetic */ DkCloudPurchasedBook f8814a;
    /* renamed from: b */
    final /* synthetic */ kj f8815b;

    kk(kj kjVar, DkCloudPurchasedBook dkCloudPurchasedBook) {
        this.f8815b = kjVar;
        this.f8814a = dkCloudPurchasedBook;
    }

    public void onDownloadCloudBookStarted() {
        DkUserPurchasedBooksManager.m5029a().m5055a(this.f8814a);
    }

    public void onDownloadCloudBookError(String str) {
        if (this.f8815b.f8813b.f8811b.f8227e == this.f8815b.f8813b.f8810a) {
            this.f8815b.f8813b.f8811b.f8226d.setEnabled(true);
        }
    }

    public void onDownloadCloudBookCanceled() {
        if (this.f8815b.f8813b.f8811b.f8227e == this.f8815b.f8813b.f8810a) {
            this.f8815b.f8813b.f8811b.f8226d.setEnabled(true);
        }
    }
}
