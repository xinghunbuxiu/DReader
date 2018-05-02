package com.duokan.reader.ui.reading;

import com.duokan.core.sys.ag;
import com.duokan.reader.domain.document.ak;

import java.util.Map;

class hm implements ag {
    final /* synthetic */ ak a;
    final /* synthetic */ hl b;

    hm(hl hlVar, ak akVar) {
        this.b = hlVar;
        this.a = akVar;
    }

    public void a(Map map) {
        for (Integer intValue : map.values()) {
            int intValue2 = intValue.intValue();
            if (intValue2 != 0 && intValue2 != 1) {
                this.b.a.a(null);
                return;
            }
        }
        this.b.c.a(true);
        this.b.c.b(this.a, this.b.b, this.b.a);
    }
}
