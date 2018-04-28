package com.duokan.reader.domain.cloud;

import java.util.Comparator;

class ci implements Comparator<DkCloudPurchasedBook> {
    /* renamed from: a */
    final /* synthetic */ ch f3815a;

    ci(ch chVar) {
        this.f3815a = chVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m5404a((DkCloudPurchasedBook) obj, (DkCloudPurchasedBook) obj2);
    }

    /* renamed from: a */
    public int m5404a(DkCloudPurchasedBook dkCloudPurchasedBook, DkCloudPurchasedBook dkCloudPurchasedBook2) {
        return -dkCloudPurchasedBook.compareUpdateTimeTo(dkCloudPurchasedBook2);
    }
}
