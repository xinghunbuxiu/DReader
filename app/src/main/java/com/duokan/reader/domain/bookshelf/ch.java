package com.duokan.reader.domain.bookshelf;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Collection;

class ch implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Collection f2955a;
    /* renamed from: b */
    final /* synthetic */ String f2956b;
    /* renamed from: c */
    final /* synthetic */ bu f2957c;

    ch(bu buVar, Collection collection, String str) {
        this.f2957c = buVar;
        this.f2955a = collection;
        this.f2956b = str;
    }

    public void run() {
        if (this.f2957c.f2868c.m3367c()) {
            Collection arrayList = new ArrayList(this.f2955a.size());
            for (Pair pair : this.f2955a) {
                int intValue = ((Integer) pair.first).intValue();
                if (intValue != -1) {
                    arrayList.add(this.f2957c.m4094b(this.f2957c.f2869d, intValue, (String) pair.second, this.f2956b, System.currentTimeMillis()));
                }
            }
            this.f2957c.m4090a(arrayList);
        }
    }
}
