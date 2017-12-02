package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.ag;
import com.duokan.core.sys.ah;

import java.util.Map;

class gf implements ag {
    final /* synthetic */ fe a;
    final /* synthetic */ fv b;

    gf(fv fvVar, fe feVar) {
        this.b = fvVar;
        this.a = feVar;
    }

    public void a(Map map) {
        ah.a(new gg(this, map), "serialPullingQueue");
    }
}
