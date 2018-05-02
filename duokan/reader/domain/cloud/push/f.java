package com.duokan.reader.domain.cloud.push;

import java.util.Comparator;

class f implements Comparator {
    final /* synthetic */ b a;

    f(b bVar) {
        this.a = bVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((q) obj, (q) obj2);
    }

    public int a(q qVar, q qVar2) {
        if (qVar.a() > qVar2.a()) {
            return -1;
        }
        if (qVar.a() < qVar2.a()) {
            return 1;
        }
        return 0;
    }
}
