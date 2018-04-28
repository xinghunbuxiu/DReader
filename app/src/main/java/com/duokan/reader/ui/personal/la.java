package com.duokan.reader.ui.personal;

import com.duokan.core.app.AppContext;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.cloud.DkCloudPurchasedBook;
import com.duokan.reader.domain.cloud.DkCloudPurchasedFiction;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.ui.C0436e;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.store.bv;
import java.util.List;

class la implements lb {
    /* renamed from: a */
    final /* synthetic */ ku f8856a;

    private la(ku kuVar) {
        this.f8856a = kuVar;
    }

    /* renamed from: a */
    public PurchasedSortType mo1932a() {
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

    /* renamed from: a */
    public void mo1934a(PurchasedSortType purchasedSortType) {
        ReaderEnv.get().setPrefString(PrivatePref.BOOKSHELF, "showing_purchased_list", purchasedSortType.toString());
        ReaderEnv.get().commitPrefs();
    }

    /* renamed from: a */
    public void mo1933a(DkCloudStoreBook dkCloudStoreBook) {
        C0436e c0436e = (C0436e) AppContext.getAppContext(this.f8856a.getContext()).queryFeature(C0436e.class);
        if (dkCloudStoreBook instanceof DkCloudPurchasedBook) {
            c0436e.pushPageSmoothly(bv.m15355a(this.f8856a.getContext(), String.valueOf(0), 1, dkCloudStoreBook.getBookUuid(), "Purchased_" + dkCloudStoreBook.getBookUuid()), null);
        } else if (dkCloudStoreBook instanceof DkCloudPurchasedFiction) {
            c0436e.pushPageSmoothly(bv.m15355a(this.f8856a.getContext(), String.valueOf(0), 2, dkCloudStoreBook.getBookUuid(), "Purchased_" + dkCloudStoreBook.getBookUuid()), null);
        }
    }

    /* renamed from: a */
    public void mo1935a(Runnable runnable, List<DkCloudStoreBook> list) {
        if (list.size() == 0) {
            be.m10286a(this.f8856a.getContext(), C0258j.bookshelf__shared__unselect_any_books, 0).show();
        } else {
            this.f8856a.m12096a(runnable, (List) list);
        }
    }

    /* renamed from: b */
    public void mo1936b() {
        this.f8856a.m12097a(this.f8856a.f8834c.m12165h(), null, null);
    }

    /* renamed from: c */
    public void mo1937c() {
        ((ReaderFeature) this.f8856a.getContext().queryFeature(ReaderFeature.class)).pushPageSmoothly(new jc(this.f8856a.getContext(), true), null);
    }

    /* renamed from: d */
    public void mo1938d() {
        ((ReaderFeature) this.f8856a.getContext().queryFeature(ReaderFeature.class)).pushPageSmoothly(bv.m15352a(this.f8856a.getContext()), null);
    }
}
