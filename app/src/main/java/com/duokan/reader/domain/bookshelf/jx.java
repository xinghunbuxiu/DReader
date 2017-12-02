package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.ag;
import com.duokan.core.sys.ah;

import java.util.Map;

class jx implements ag {
    final /* synthetic */ fe a;
    final /* synthetic */ jv b;

    jx(jv jvVar, fe feVar) {
        this.b = jvVar;
        this.a = feVar;
    }

    public void a(Map map) {
        ah.a(new jy(this, map), "serialPullingQueue");
    }
}
