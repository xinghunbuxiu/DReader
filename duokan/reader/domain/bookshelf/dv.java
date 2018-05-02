package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.ab;

import java.util.ArrayList;
import java.util.List;

class dv implements ec {
    final /* synthetic */ List a;
    final /* synthetic */ ee b;
    final /* synthetic */ dh c;

    dv(dh dhVar, List list, ee eeVar) {
        this.c = dhVar;
        this.a = list;
        this.b = eeVar;
    }

    public void a() {
        ab b = this.c.c;
        ArrayList arrayList = new ArrayList(this.a.size());
        for (dg dgVar : this.a) {
            dg a = this.c.d.a(dgVar.a, dgVar.b);
            if (a != null && a.f == dgVar.f && a.g == dgVar.g) {
                if (a.f == 1) {
                    a.e = false;
                    a.f = 0;
                } else if (a.f == 2) {
                    this.c.d.b(a);
                }
                arrayList.add(a.a());
            }
        }
        new dw(this, b, arrayList).open();
    }

    public void a(String str) {
        this.b.a(str);
    }
}
