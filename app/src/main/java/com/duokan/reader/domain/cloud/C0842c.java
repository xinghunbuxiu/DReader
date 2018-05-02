package com.duokan.reader.domain.cloud;

import java.text.Collator;
import java.util.Comparator;

/* renamed from: com.duokan.reader.domain.cloud.c */
class C0842c implements Comparator<DkCloudBook> {
    /* renamed from: a */
    final /* synthetic */ Collator f3798a;
    /* renamed from: b */
    final /* synthetic */ C0840a f3799b;

    C0842c(C0840a c0840a, Collator collator) {
        this.f3799b = c0840a;
        this.f3798a = collator;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m5373a((DkCloudBook) obj, (DkCloudBook) obj2);
    }

    /* renamed from: a */
    public int m5373a(DkCloudBook dkCloudBook, DkCloudBook dkCloudBook2) {
        return this.f3798a.compare(dkCloudBook.getTitle(), dkCloudBook2.getTitle());
    }
}
