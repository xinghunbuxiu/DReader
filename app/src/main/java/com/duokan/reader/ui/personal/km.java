package com.duokan.reader.ui.personal;

import com.duokan.c.j;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.cloud.DkCloudPurchasedBook;
import com.duokan.reader.domain.cloud.DkCloudPurchasedFiction;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.ui.e;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.store.bv;

import java.util.List;

class km implements kn {
    final /* synthetic */ kg a;

    private km(kg kgVar) {
        this.a = kgVar;
    }

    public PurchasedSortType a() {
        String prefString = ReaderEnv.get().getPrefString(PrivatePref.BOOKSHELF, "showing_purchased_list", PurchasedSortType.TIME.toString());
        if (prefString.equals("purchased")) {
            return PurchasedSortType.TIME;
        }
        if (prefString.equals("cloud_only")) {
            return PurchasedSortType.NAME;
        }
        if (prefString.equals("group")) {
            return PurchasedSortType.GROUP;
        }
        if (prefString.equals(PurchasedSortType.CLOUD_ONLY.toString())) {
            return PurchasedSortType.NAME;
        }
        return PurchasedSortType.valueOf(prefString);
    }

    public void a(PurchasedSortType purchasedSortType) {
        ReaderEnv.get().setPrefString(PrivatePref.BOOKSHELF, "showing_purchased_list", purchasedSortType.toString());
        ReaderEnv.get().commitPrefs();
    }

    public void a(DkCloudStoreBook dkCloudStoreBook) {
        e eVar = (e) MyContextWrapper.getFeature(this.a.getContext()).queryFeature(e.class);
        if (dkCloudStoreBook instanceof DkCloudPurchasedBook) {
            eVar.pushPageSmoothly(bv.a(this.a.getContext(), String.valueOf(0), 1, dkCloudStoreBook.getBookUuid(), "Purchased_" + dkCloudStoreBook.getBookUuid()), null);
        } else if (dkCloudStoreBook instanceof DkCloudPurchasedFiction) {
            eVar.pushPageSmoothly(bv.a(this.a.getContext(), String.valueOf(0), 2, dkCloudStoreBook.getBookUuid(), "Purchased_" + dkCloudStoreBook.getBookUuid()), null);
        }
    }

    public void a(Runnable runnable, List list) {
        if (list.size() == 0) {
            be.a(this.a.getContext(), j.bookshelf__shared__unselect_any_books, 0).show();
        } else {
            this.a.a(runnable, list);
        }
    }

    public void b() {
        this.a.a(this.a.c.h(), null, null);
    }

    public void c() {
        ((ReaderFeature) this.a.getContext().queryFeature(ReaderFeature.class)).pushPageSmoothly(new ip(this.a.getContext(), true), null);
    }

    public void d() {
        ((ReaderFeature) this.a.getContext().queryFeature(ReaderFeature.class)).pushPageSmoothly(bv.a(this.a.getContext()), null);
    }
}
