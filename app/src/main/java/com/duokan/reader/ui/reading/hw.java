package com.duokan.reader.ui.reading;

import com.duokan.core.sys.ag;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.epub.av;
import java.util.Map;

class hw implements ag<Map<av, Integer>> {
    /* renamed from: a */
    final /* synthetic */ ak f10357a;
    /* renamed from: b */
    final /* synthetic */ hv f10358b;

    hw(hv hvVar, ak akVar) {
        this.f10358b = hvVar;
        this.f10357a = akVar;
    }

    public /* synthetic */ void run(Object obj) {
        m14396a((Map) obj);
    }

    /* renamed from: a */
    public void m14396a(Map<av, Integer> map) {
        for (Integer intValue : map.values()) {
            int intValue2 = intValue.intValue();
            if (intValue2 != 0 && intValue2 != 1) {
                this.f10358b.f10354a.run(null);
                return;
            }
        }
        this.f10358b.f10356c.mo2185a(true);
        this.f10358b.f10356c.m13100b(this.f10357a, this.f10358b.f10355b, this.f10358b.f10354a);
    }
}
