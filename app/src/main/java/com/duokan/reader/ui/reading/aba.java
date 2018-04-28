package com.duokan.reader.ui.reading;

import com.duokan.core.sys.ag;
import com.duokan.reader.domain.document.ak;
import java.util.Map;

class aba implements ag<Map<String, Integer>> {
    /* renamed from: a */
    final /* synthetic */ ak f9374a;
    /* renamed from: b */
    final /* synthetic */ aax f9375b;

    aba(aax aax, ak akVar) {
        this.f9375b = aax;
        this.f9374a = akVar;
    }

    public /* synthetic */ void run(Object obj) {
        m13199a((Map) obj);
    }

    /* renamed from: a */
    public void m13199a(Map<String, Integer> map) {
        for (Integer intValue : map.values()) {
            int intValue2 = intValue.intValue();
            if (intValue2 != 0 && intValue2 != 1) {
                this.f9375b.f9364a.run(null);
                return;
            }
        }
        this.f9375b.f9366c.mo2185a(true);
        this.f9375b.f9366c.m13100b(this.f9374a, this.f9375b.f9365b, this.f9375b.f9364a);
    }
}
