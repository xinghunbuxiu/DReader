package com.duokan.reader.ui.store;

import com.duokan.core.app.y;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.domain.statistics.a;

public class ba extends bl {
    public ba(y yVar, bq bqVar) {
        super(yVar, bqVar);
    }

    protected void a() {
        this.a.loadUrl(p.i().c());
        a.k().a("serial_store", 3);
    }
}
