package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.cloud.DkCloudStoreBook;

import java.util.Comparator;

class nd implements Comparator {
    final /* synthetic */ nc a;

    nd(nc ncVar) {
        this.a = ncVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((DkCloudStoreBook) obj, (DkCloudStoreBook) obj2);
    }

    public int a(DkCloudStoreBook dkCloudStoreBook, DkCloudStoreBook dkCloudStoreBook2) {
        return -dkCloudStoreBook.comparePurchaseTimeTo(dkCloudStoreBook2);
    }
}
