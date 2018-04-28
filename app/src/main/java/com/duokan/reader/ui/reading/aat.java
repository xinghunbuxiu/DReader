package com.duokan.reader.ui.reading;

import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.sys.ag;
import java.util.Map;
import java.util.Map.Entry;

class aat implements ag<Map<String, Integer>> {
    /* renamed from: a */
    final /* synthetic */ aas f9351a;

    aat(aas aas) {
        this.f9351a = aas;
    }

    public /* synthetic */ void run(Object obj) {
        m12910a((Map) obj);
    }

    /* renamed from: a */
    public void m12910a(Map<String, Integer> map) {
        C0328a.m757c().m764b(map.size() == this.f9351a.f9347a.size());
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            int intValue = ((Integer) entry.getValue()).intValue();
            this.f9351a.f9350d.f9309P.remove(str);
            if (intValue >= 1000) {
                this.f9351a.f9350d.f9310Q.put(str, Integer.valueOf(intValue));
            }
        }
        this.f9351a.f9350d.m12832a(false);
        if (this.f9351a.f9349c != null) {
            this.f9351a.f9349c.run(map);
        }
    }
}
