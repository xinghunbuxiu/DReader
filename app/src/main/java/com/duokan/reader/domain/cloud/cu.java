package com.duokan.reader.domain.cloud;

import java.util.Comparator;

class cu implements Comparator {
    final /* synthetic */ ct a;

    cu(ct ctVar) {
        this.a = ctVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((DkCloudPurchasedBook) obj, (DkCloudPurchasedBook) obj2);
    }

    public int a(DkCloudPurchasedBook dkCloudPurchasedBook, DkCloudPurchasedBook dkCloudPurchasedBook2) {
        return -dkCloudPurchasedBook.compareUpdateTimeTo(dkCloudPurchasedBook2);
    }
}
