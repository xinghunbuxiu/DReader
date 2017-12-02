package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.bookshelf.a;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.domain.document.d;

import java.util.Comparator;

class sg implements Comparator {
    final /* synthetic */ rx a;

    sg(rx rxVar) {
        this.a = rxVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((a) obj, (a) obj2);
    }

    public int a(a aVar, a aVar2) {
        bb a = this.a.getDocument().a((d) aVar.d(), (d) aVar.e());
        com.duokan.reader.domain.document.a a2 = this.a.getDocument().a((d) aVar2.d(), (d) aVar2.e());
        if (a.a(a2)) {
            return -1;
        }
        if (a.c(a2)) {
            return 1;
        }
        return 0;
    }
}
