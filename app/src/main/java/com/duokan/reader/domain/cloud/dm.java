package com.duokan.reader.domain.cloud;

import java.util.Comparator;

class dm implements Comparator<DkCloudPurchasedFiction> {
    private dm() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m5449a((DkCloudPurchasedFiction) obj, (DkCloudPurchasedFiction) obj2);
    }

    /* renamed from: a */
    public int m5449a(DkCloudPurchasedFiction dkCloudPurchasedFiction, DkCloudPurchasedFiction dkCloudPurchasedFiction2) {
        return -dkCloudPurchasedFiction.comparePurchaseTimeTo(dkCloudPurchasedFiction2);
    }
}
