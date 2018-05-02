package com.duokan.reader.domain.bookshelf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class cl implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ bv b;

    cl(bv bvVar, List list) {
        this.b = bvVar;
        this.a = list;
    }

    public void run() {
        if (this.b.c.c()) {
            Collection arrayList = new ArrayList(this.a.size());
            for (ct ctVar : this.a) {
                int i = ctVar.a;
                if (i != -1) {
                    String str = ctVar.b;
                    String str2;
                    if (ctVar.c == 1) {
                        str2 = ((cr) ctVar.d).a;
                        if (str2 == null) {
                            str2 = "";
                        }
                        arrayList.add(this.b.a(this.b.d, i, str, str2, System.currentTimeMillis()));
                    } else if (ctVar.c == 2) {
                        str2 = ((cu) ctVar.d).b;
                        if (str2 == null) {
                            str2 = "";
                        }
                        arrayList.add(this.b.b(this.b.d, i, str, str2, System.currentTimeMillis()));
                    } else if (ctVar.c == 3) {
                        arrayList.add(this.b.a(this.b.d, i, str, System.currentTimeMillis()));
                    }
                }
            }
            this.b.a(arrayList);
        }
    }
}
