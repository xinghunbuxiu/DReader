package com.duokan.reader.domain.bookshelf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class ci implements Runnable {
    /* renamed from: a */
    final /* synthetic */ List f2958a;
    /* renamed from: b */
    final /* synthetic */ bu f2959b;

    ci(bu buVar, List list) {
        this.f2959b = buVar;
        this.f2958a = list;
    }

    public void run() {
        if (this.f2959b.f2868c.m3367c()) {
            Collection arrayList = new ArrayList(this.f2958a.size());
            for (cq cqVar : this.f2958a) {
                int i = cqVar.f2984a;
                if (i != -1) {
                    String str = cqVar.f2985b;
                    String str2;
                    if (cqVar.f2986c == 1) {
                        str2 = ((co) cqVar.f2987d).f2979a;
                        if (str2 == null) {
                            str2 = "";
                        }
                        arrayList.add(this.f2959b.m4076a(this.f2959b.f2869d, i, str, str2, System.currentTimeMillis()));
                    } else if (cqVar.f2986c == 2) {
                        str2 = ((cr) cqVar.f2987d).f2989b;
                        if (str2 == null) {
                            str2 = "";
                        }
                        arrayList.add(this.f2959b.m4094b(this.f2959b.f2869d, i, str, str2, System.currentTimeMillis()));
                    } else if (cqVar.f2986c == 3) {
                        arrayList.add(this.f2959b.m4075a(this.f2959b.f2869d, i, str, System.currentTimeMillis()));
                    }
                }
            }
            this.f2959b.m4090a(arrayList);
        }
    }
}
