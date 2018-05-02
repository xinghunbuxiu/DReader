package com.duokan.reader.domain.cloud;

import java.text.Collator;
import java.util.Comparator;

/* renamed from: com.duokan.reader.domain.cloud.b */
class C0841b implements Comparator<C0840a> {
    /* renamed from: a */
    final /* synthetic */ Collator f3732a;
    /* renamed from: b */
    final /* synthetic */ C0840a f3733b;

    C0841b(C0840a c0840a, Collator collator) {
        this.f3733b = c0840a;
        this.f3732a = collator;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m5337a((C0840a) obj, (C0840a) obj2);
    }

    /* renamed from: a */
    public int m5337a(C0840a c0840a, C0840a c0840a2) {
        return this.f3732a.compare(c0840a.m5258a(), c0840a2.m5258a());
    }
}
