package com.duokan.reader.domain.cloud;

import java.util.Comparator;

class cd implements Comparator<DkCloudPurchasedBook> {
    private cd() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m5382a((DkCloudPurchasedBook) obj, (DkCloudPurchasedBook) obj2);
    }

    /* renamed from: a */
    public int m5382a(DkCloudPurchasedBook dkCloudPurchasedBook, DkCloudPurchasedBook dkCloudPurchasedBook2) {
        return -dkCloudPurchasedBook.comparePurchaseTimeTo(dkCloudPurchasedBook2);
    }
}
