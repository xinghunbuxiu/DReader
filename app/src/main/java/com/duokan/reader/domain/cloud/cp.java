package com.duokan.reader.domain.cloud;

import java.util.Comparator;

class cp implements Comparator {
    private cp() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((DkCloudPurchasedBook) obj, (DkCloudPurchasedBook) obj2);
    }

    public int a(DkCloudPurchasedBook dkCloudPurchasedBook, DkCloudPurchasedBook dkCloudPurchasedBook2) {
        return -dkCloudPurchasedBook.comparePurchaseTimeTo(dkCloudPurchasedBook2);
    }
}
