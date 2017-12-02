package com.duokan.reader.domain.bookshelf;

import android.util.Pair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class im implements Runnable {
    final /* synthetic */ Collection a;
    final /* synthetic */ String b;
    final /* synthetic */ hi c;

    im(hi hiVar, Collection collection, String str) {
        this.c = hiVar;
        this.a = collection;
        this.b = str;
    }

    public void run() {
        ArrayList arrayList = new ArrayList(this.a.size());
        for (c cVar : this.a) {
            c cVar2;
            if (this.c.g(cVar2)) {
                arrayList.add(cVar2);
            }
        }
        if (arrayList.size() > 0) {
            Collection arrayList2 = new ArrayList(arrayList.size());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                cVar2 = (c) it.next();
                arrayList2.add(new Pair(Integer.valueOf(cVar2.ao()), cVar2.ap()));
            }
            bv.a().a(this.b, arrayList2);
        }
    }
}
