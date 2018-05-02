package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.bookshelf.a;

import java.util.Comparator;

class nl implements Comparator {
    final /* synthetic */ nk a;

    nl(nk nkVar) {
        this.a = nkVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((a) obj, (a) obj2);
    }

    public int a(a aVar, a aVar2) {
        if (aVar.d().c(aVar2.d())) {
            return 1;
        }
        if (aVar.d().a(aVar2.d())) {
            return -1;
        }
        return 0;
    }
}
