package com.duokan.reader.domain.cloud;

import java.text.Collator;
import java.util.Comparator;

class b implements Comparator {
    final /* synthetic */ Collator a;
    final /* synthetic */ a b;

    b(a aVar, Collator collator) {
        this.b = aVar;
        this.a = collator;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((a) obj, (a) obj2);
    }

    public int a(a aVar, a aVar2) {
        return this.a.compare(aVar.a(), aVar2.a());
    }
}
