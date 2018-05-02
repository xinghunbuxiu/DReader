package com.duokan.reader.domain.cloud;

import java.text.Collator;
import java.util.Comparator;

class c implements Comparator {
    final /* synthetic */ Collator a;
    final /* synthetic */ a b;

    c(a aVar, Collator collator) {
        this.b = aVar;
        this.a = collator;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((DkCloudBook) obj, (DkCloudBook) obj2);
    }

    public int a(DkCloudBook dkCloudBook, DkCloudBook dkCloudBook2) {
        return this.a.compare(dkCloudBook.getTitle(), dkCloudBook2.getTitle());
    }
}
