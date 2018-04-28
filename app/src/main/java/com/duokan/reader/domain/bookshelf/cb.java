package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.al;
import java.util.ArrayList;
import java.util.List;

class cb implements cy {
    /* renamed from: a */
    final /* synthetic */ List f2931a;
    /* renamed from: b */
    final /* synthetic */ cx f2932b;
    /* renamed from: c */
    final /* synthetic */ bu f2933c;

    cb(bu buVar, List list, cx cxVar) {
        this.f2933c = buVar;
        this.f2931a = list;
        this.f2932b = cxVar;
    }

    /* renamed from: a */
    public void mo995a(bs bsVar) {
        al b = this.f2933c.f2868c;
        ArrayList arrayList = new ArrayList(this.f2931a.size());
        for (bt btVar : this.f2931a) {
            bt a = this.f2933c.f2869d.m4277a(btVar.f2857a, btVar.f2858b);
            if (a != null && a.f2864h == btVar.f2864h && a.f2865i == btVar.f2865i) {
                if (a.f2864h == 1 || a.f2864h == 2) {
                    a.f2863g = false;
                    a.f2860d = bsVar.m4060a(a.f2857a);
                    a.f2864h = 0;
                } else if (a.f2864h == 3) {
                    this.f2933c.f2869d.m4281b(a);
                }
                arrayList.add(a.m4068a());
            }
        }
        new cc(this, aq.f2771a, b, bsVar, arrayList).open();
    }

    /* renamed from: a */
    public void mo994a() {
        this.f2932b.mo978b();
    }

    /* renamed from: a */
    public void mo996a(String str) {
        this.f2932b.mo977a("");
    }
}
