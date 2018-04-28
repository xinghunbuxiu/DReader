package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import java.text.Collator;
import java.util.Comparator;

class fv implements Comparator<DkCloudStoreBook> {
    /* renamed from: a */
    final /* synthetic */ Collator f8570a;
    /* renamed from: b */
    final /* synthetic */ fu f8571b;

    fv(fu fuVar, Collator collator) {
        this.f8571b = fuVar;
        this.f8570a = collator;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m11834a((DkCloudStoreBook) obj, (DkCloudStoreBook) obj2);
    }

    /* renamed from: a */
    public int m11834a(DkCloudStoreBook dkCloudStoreBook, DkCloudStoreBook dkCloudStoreBook2) {
        return dkCloudStoreBook.compareNameTo(this.f8570a, dkCloudStoreBook2);
    }
}
