package com.duokan.reader.domain.cloud;

import java.util.Comparator;

class eb implements Comparator {
    private eb() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((DkCloudPurchasedFiction) obj, (DkCloudPurchasedFiction) obj2);
    }

    public int a(DkCloudPurchasedFiction dkCloudPurchasedFiction, DkCloudPurchasedFiction dkCloudPurchasedFiction2) {
        return -dkCloudPurchasedFiction.comparePurchaseTimeTo(dkCloudPurchasedFiction2);
    }
}
