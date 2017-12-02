package com.duokan.reader.domain.bookshelf;

import android.util.Pair;

import java.util.ArrayList;
import java.util.Collection;

class ck implements Runnable {
    final /* synthetic */ Collection a;
    final /* synthetic */ String b;
    final /* synthetic */ bv c;

    ck(bv bvVar, Collection collection, String str) {
        this.c = bvVar;
        this.a = collection;
        this.b = str;
    }

    public void run() {
        if (this.c.c.c()) {
            Collection arrayList = new ArrayList(this.a.size());
            for (Pair pair : this.a) {
                int intValue = ((Integer) pair.first).intValue();
                if (intValue != -1) {
                    arrayList.add(this.c.b(this.c.d, intValue, (String) pair.second, this.b, System.currentTimeMillis()));
                }
            }
            this.c.a(arrayList);
        }
    }
}
