package com.duokan.reader.domain.cloud;

import java.util.Comparator;

class ds implements Comparator<DkCloudPurchasedFiction> {
    /* renamed from: a */
    final /* synthetic */ dr f3891a;

    ds(dr drVar) {
        this.f3891a = drVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m5467a((DkCloudPurchasedFiction) obj, (DkCloudPurchasedFiction) obj2);
    }

    /* renamed from: a */
    public int m5467a(DkCloudPurchasedFiction dkCloudPurchasedFiction, DkCloudPurchasedFiction dkCloudPurchasedFiction2) {
        return -dkCloudPurchasedFiction.compareUpdateTimeTo(dkCloudPurchasedFiction2);
    }
}
