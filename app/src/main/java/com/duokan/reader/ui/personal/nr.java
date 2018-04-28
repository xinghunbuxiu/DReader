package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import java.util.Comparator;

class nr implements Comparator<DkCloudStoreBook> {
    /* renamed from: a */
    final /* synthetic */ nq f9015a;

    nr(nq nqVar) {
        this.f9015a = nqVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m12363a((DkCloudStoreBook) obj, (DkCloudStoreBook) obj2);
    }

    /* renamed from: a */
    public int m12363a(DkCloudStoreBook dkCloudStoreBook, DkCloudStoreBook dkCloudStoreBook2) {
        return -dkCloudStoreBook.comparePurchaseTimeTo(dkCloudStoreBook2);
    }
}
