package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.ag;
import com.duokan.core.sys.ah;
import java.util.Map;

class fz implements ag<Map<String, ex>> {
    /* renamed from: a */
    final /* synthetic */ ey f3212a;
    /* renamed from: b */
    final /* synthetic */ fp f3213b;

    fz(fp fpVar, ey eyVar) {
        this.f3213b = fpVar;
        this.f3212a = eyVar;
    }

    public /* synthetic */ void run(Object obj) {
        m4503a((Map) obj);
    }

    /* renamed from: a */
    public void m4503a(Map<String, ex> map) {
        ah.m866a(new ga(this, map), "serialPullingQueue");
    }
}
