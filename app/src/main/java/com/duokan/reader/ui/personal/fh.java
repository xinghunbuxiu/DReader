package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.cloud.DkCloudStoreBook;

import java.text.Collator;
import java.util.Comparator;

class fh implements Comparator {
    final /* synthetic */ Collator a;
    final /* synthetic */ fg b;

    fh(fg fgVar, Collator collator) {
        this.b = fgVar;
        this.a = collator;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((DkCloudStoreBook) obj, (DkCloudStoreBook) obj2);
    }

    public int a(DkCloudStoreBook dkCloudStoreBook, DkCloudStoreBook dkCloudStoreBook2) {
        return dkCloudStoreBook.compareNameTo(this.a, dkCloudStoreBook2);
    }
}
