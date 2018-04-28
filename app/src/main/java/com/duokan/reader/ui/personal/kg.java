package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.AppContext;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.ui.store.DkCloudBookStatusHelper.StoreBookStatus;

class kg implements OnClickListener {
    /* renamed from: a */
    static final /* synthetic */ boolean f8806a = (!PurchasedBookItemView.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ StoreBookStatus f8807b;
    /* renamed from: c */
    final /* synthetic */ PurchasedBookItemView f8808c;

    kg(PurchasedBookItemView purchasedBookItemView, StoreBookStatus storeBookStatus) {
        this.f8808c = purchasedBookItemView;
        this.f8807b = storeBookStatus;
    }

    public void onClick(View view) {
        switch (this.f8807b) {
            case UPDATE:
                PurchasedBookItemView.m11369f(this.f8808c, this.f8808c.f8227e);
                return;
            case DOWNLOAD:
            case DOWNLOADING:
                C0800c b = ai.m3980a().m3906b(this.f8808c.f8227e.getBookUuid());
                if (b != null) {
                    ((ReaderFeature) AppContext.getAppContext(DkApp.get()).queryFeature(ReaderFeature.class)).openBook(b);
                    return;
                }
                return;
            case ORDER:
                PurchasedBookItemView.m11368e(this.f8808c, this.f8808c.f8227e);
                return;
            default:
                if (!f8806a) {
                    throw new AssertionError();
                }
                return;
        }
    }
}
