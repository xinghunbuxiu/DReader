package com.duokan.reader.ui.reading;

import com.duokan.core.sys.ag;
import com.duokan.reader.domain.document.epub.av;
import java.util.Map;
import java.util.Map.Entry;

class hq implements ag<Map<av, Integer>> {
    /* renamed from: a */
    final /* synthetic */ ag f10346a;
    /* renamed from: b */
    final /* synthetic */ hl f10347b;

    hq(hl hlVar, ag agVar) {
        this.f10347b = hlVar;
        this.f10346a = agVar;
    }

    public /* synthetic */ void run(Object obj) {
        m14366a((Map) obj);
    }

    /* renamed from: a */
    public void m14366a(Map<av, Integer> map) {
        for (Entry entry : map.entrySet()) {
            av avVar = (av) entry.getKey();
            int intValue = ((Integer) entry.getValue()).intValue();
            this.f10347b.f10336O.remove(avVar);
            if (intValue == 0 || intValue == 1) {
                this.f10347b.f10338Q.add(avVar);
            } else if (!(intValue == -1 || this.f10347b.f10337P.containsKey(avVar))) {
                this.f10347b.f10337P.put(avVar, Integer.valueOf(intValue));
                this.f10347b.m12832a(false);
            }
        }
        this.f10347b.c.mo2103b(new hr(this, map));
    }
}
