package com.duokan.reader.ui.reading;

import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.sys.ag;
import com.duokan.reader.domain.bookshelf.ee;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class aao implements ag<Map<String, Integer>> {
    /* renamed from: a */
    final /* synthetic */ List f9338a;
    /* renamed from: b */
    final /* synthetic */ ee f9339b;
    /* renamed from: c */
    final /* synthetic */ abd f9340c;
    /* renamed from: d */
    final /* synthetic */ ag f9341d;
    /* renamed from: e */
    final /* synthetic */ aab f9342e;

    aao(aab aab, List list, ee eeVar, abd abd, ag agVar) {
        this.f9342e = aab;
        this.f9338a = list;
        this.f9339b = eeVar;
        this.f9340c = abd;
        this.f9341d = agVar;
    }

    public /* synthetic */ void run(Object obj) {
        m12908a((Map) obj);
    }

    /* renamed from: a */
    public void m12908a(Map<String, Integer> map) {
        C0328a.m757c().m764b(map.size() == this.f9338a.size());
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            int intValue = ((Integer) entry.getValue()).intValue();
            this.f9342e.f9304K.remove(str);
            if (intValue == 0) {
                this.f9342e.f9306M.add(str);
            } else if (intValue == 1) {
                if (!this.f9340c.mo2361e((long) this.f9339b.mo1016s(str))) {
                    this.f9342e.f9306M.add(str);
                }
            } else if (!(intValue == -1 || this.f9342e.f9305L.containsKey(str))) {
                this.f9342e.f9305L.put(str, Integer.valueOf(intValue));
                this.f9342e.m12832a(false);
            }
        }
        this.f9342e.c.mo2103b(new aap(this, map));
    }
}
