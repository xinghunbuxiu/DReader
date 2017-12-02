package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.ab;

import java.util.ArrayList;
import java.util.List;

class cd implements db {
    final /* synthetic */ List a;
    final /* synthetic */ da b;
    final /* synthetic */ bv c;

    cd(bv bvVar, List list, da daVar) {
        this.c = bvVar;
        this.a = list;
        this.b = daVar;
    }

    public void a(bt btVar) {
        ab b = this.c.c;
        ArrayList arrayList = new ArrayList(this.a.size());
        for (bu buVar : this.a) {
            bu a = this.c.d.a(buVar.a, buVar.b);
            if (a != null && a.h == buVar.h && a.i == buVar.i) {
                if (a.h == 1 || a.h == 2) {
                    a.g = false;
                    a.d = btVar.a(a.a);
                    a.h = 0;
                } else if (a.h == 3) {
                    this.c.d.b(a);
                }
                arrayList.add(a.a());
            }
        }
        new ce(this, b, btVar, arrayList).open();
    }

    public void a() {
        this.b.b();
    }

    public void a(String str) {
        this.b.a("");
    }
}
