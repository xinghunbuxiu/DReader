package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.cloud.DkCloudPurchasedBook;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.ui.store.al;

class jw implements al {
    final /* synthetic */ DkCloudPurchasedBook a;
    final /* synthetic */ jv b;

    jw(jv jvVar, DkCloudPurchasedBook dkCloudPurchasedBook) {
        this.b = jvVar;
        this.a = dkCloudPurchasedBook;
    }

    public void onDownloadCloudBookStarted() {
        DkUserPurchasedBooksManager.a().a(this.a);
    }

    public void onDownloadCloudBookError(String str) {
        if (this.b.b.b.e == this.b.b.a) {
            this.b.b.b.d.setEnabled(true);
        }
    }

    public void onDownloadCloudBookCanceled() {
        if (this.b.b.b.e == this.b.b.a) {
            this.b.b.b.d.setEnabled(true);
        }
    }
}
