package com.duokan.reader.domain.bookshelf;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class ig implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Collection f3347a;
    /* renamed from: b */
    final /* synthetic */ String f3348b;
    /* renamed from: c */
    final /* synthetic */ hc f3349c;

    ig(hc hcVar, Collection collection, String str) {
        this.f3349c = hcVar;
        this.f3347a = collection;
        this.f3348b = str;
    }

    public void run() {
        ArrayList arrayList = new ArrayList(this.f3347a.size());
        for (C0800c c0800c : this.f3347a) {
            C0800c c0800c2;
            if (this.f3349c.m3847g(c0800c2)) {
                arrayList.add(c0800c2);
            }
        }
        if (arrayList.size() > 0) {
            Collection arrayList2 = new ArrayList(arrayList.size());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                c0800c2 = (C0800c) it.next();
                arrayList2.add(new Pair(Integer.valueOf(c0800c2.aq()), c0800c2.ar()));
            }
            bu.m4077a().m4109a(this.f3348b, arrayList2);
        }
    }
}
