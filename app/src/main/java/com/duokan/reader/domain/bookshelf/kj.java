package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.ag;
import com.duokan.core.sys.ah;
import java.util.Map;

class kj implements ag<Map<String, ex>> {
    /* renamed from: a */
    final /* synthetic */ ey f3463a;
    /* renamed from: b */
    final /* synthetic */ kh f3464b;

    kj(kh khVar, ey eyVar) {
        this.f3464b = khVar;
        this.f3463a = eyVar;
    }

    public /* synthetic */ void run(Object obj) {
        m4843a((Map) obj);
    }

    /* renamed from: a */
    public void m4843a(Map<String, ex> map) {
        ah.m866a(new kk(this, map), "serialPullingQueue");
    }
}
