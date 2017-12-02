package com.duokan.reader.ui.store;

import com.duokan.core.app.y;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.domain.statistics.a;

public class f extends bl {
    public f(y yVar, bq bqVar) {
        super(yVar, bqVar);
    }

    protected void a() {
        this.a.loadUrl(p.i().d());
        a.k().a("pub_store", 3);
    }
}
