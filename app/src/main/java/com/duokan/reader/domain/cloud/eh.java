package com.duokan.reader.domain.cloud;

import java.util.Comparator;

class eh implements Comparator {
    final /* synthetic */ eg a;

    eh(eg egVar) {
        this.a = egVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((DkCloudPurchasedFiction) obj, (DkCloudPurchasedFiction) obj2);
    }

    public int a(DkCloudPurchasedFiction dkCloudPurchasedFiction, DkCloudPurchasedFiction dkCloudPurchasedFiction2) {
        return -dkCloudPurchasedFiction.compareUpdateTimeTo(dkCloudPurchasedFiction2);
    }
}
