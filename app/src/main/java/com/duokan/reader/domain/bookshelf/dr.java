package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.al;
import java.util.ArrayList;
import java.util.List;

class dr implements dx {
    /* renamed from: a */
    final /* synthetic */ List f3056a;
    /* renamed from: b */
    final /* synthetic */ dz f3057b;
    /* renamed from: c */
    final /* synthetic */ de f3058c;

    dr(de deVar, List list, dz dzVar) {
        this.f3058c = deVar;
        this.f3056a = list;
        this.f3057b = dzVar;
    }

    /* renamed from: a */
    public void mo1006a() {
        al b = this.f3058c.f3011c;
        ArrayList arrayList = new ArrayList(this.f3056a.size());
        for (dd ddVar : this.f3056a) {
            dd a = this.f3058c.f3012d.m4371a(ddVar.f3002a, ddVar.f3003b);
            if (a != null && a.f3007f == ddVar.f3007f && a.f3008g == ddVar.f3008g) {
                if (a.f3007f == 1) {
                    a.f3006e = false;
                    a.f3007f = 0;
                } else if (a.f3007f == 2) {
                    this.f3058c.f3012d.m4376b(a);
                }
                arrayList.add(a.m4305a());
            }
        }
        new ds(this, aq.f2771a, b, arrayList).open();
    }

    /* renamed from: a */
    public void mo1007a(String str) {
        this.f3057b.mo1005a(str);
    }
}
