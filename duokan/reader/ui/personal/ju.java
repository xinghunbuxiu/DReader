package com.duokan.reader.ui.personal;

import android.text.TextUtils;

import com.duokan.core.app.ManagedApp;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.domain.store.h;
import com.duokan.reader.ui.bookshelf.ay;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.store.o;

final class ju implements h {
    final /* synthetic */ DkCloudStoreBook a;
    final /* synthetic */ PurchasedBookItemView b;

    ju(DkCloudStoreBook dkCloudStoreBook, PurchasedBookItemView purchasedBookItemView) {
        this.a = dkCloudStoreBook;
        this.b = purchasedBookItemView;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        ay.a(ManagedApp.get().getTopActivity(), ((DkStoreBookDetail) dkStoreItem).getEpubSize(), new jv(this, dkStoreItem));
    }

    public void onFetchBookDetailError(String str) {
        o.a().c(this.a.getBookUuid());
        if (!TextUtils.isEmpty(str)) {
            be.a(DkApp.get(), (CharSequence) str, 1).show();
        }
        if (this.b.e == this.a) {
            this.b.d.setEnabled(true);
        }
    }
}
