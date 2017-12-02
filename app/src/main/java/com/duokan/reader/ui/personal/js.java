package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.x;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.ui.store.DkCloudBookStatusHelper.StoreBookStatus;

class js implements OnClickListener {
    static final /* synthetic */ boolean a = (!PurchasedBookItemView.class.desiredAssertionStatus());
    final /* synthetic */ StoreBookStatus b;
    final /* synthetic */ PurchasedBookItemView c;

    js(PurchasedBookItemView purchasedBookItemView, StoreBookStatus storeBookStatus) {
        this.c = purchasedBookItemView;
        this.b = storeBookStatus;
    }

    public void onClick(View view) {
        switch (ka.a[this.b.ordinal()]) {
            case 1:
                PurchasedBookItemView.f(this.c, this.c.e);
                return;
            case 2:
            case 3:
                c b = ai.a().b(this.c.e.getBookUuid());
                if (b != null) {
                    ((ReaderFeature) x.a(DkApp.get()).queryFeature(ReaderFeature.class)).openBook(b);
                    return;
                }
                return;
            case 4:
                PurchasedBookItemView.e(this.c, this.c.e);
                return;
            default:
                if (!a) {
                    throw new AssertionError();
                }
                return;
        }
    }
}
