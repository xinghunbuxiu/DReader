package com.duokan.reader.ui.personal;

import android.text.TextUtils;
import com.duokan.core.app.ManagedApp;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.domain.store.C0466h;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.ui.bookshelf.be;
import com.duokan.reader.ui.store.C1502o;

final class ki implements C0466h {
    /* renamed from: a */
    final /* synthetic */ DkCloudStoreBook f8810a;
    /* renamed from: b */
    final /* synthetic */ PurchasedBookItemView f8811b;

    ki(DkCloudStoreBook dkCloudStoreBook, PurchasedBookItemView purchasedBookItemView) {
        this.f8810a = dkCloudStoreBook;
        this.f8811b = purchasedBookItemView;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        be.m9188a(ManagedApp.get().getTopActivity(), ((DkStoreBookDetail) dkStoreItem).getEpubSize(), new kj(this, dkStoreItem));
    }

    public void onFetchBookDetailError(String str) {
        C1502o.m15410a().m15436c(this.f8810a.getBookUuid());
        if (!TextUtils.isEmpty(str)) {
            com.duokan.reader.ui.general.be.m10287a(DkApp.get(), (CharSequence) str, 1).show();
        }
        if (this.f8811b.f8227e == this.f8810a) {
            this.f8811b.f8226d.setEnabled(true);
        }
    }
}
