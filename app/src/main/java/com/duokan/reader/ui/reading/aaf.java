package com.duokan.reader.ui.reading;

import com.duokan.core.sys.ag;
import com.duokan.reader.domain.bookshelf.ej;

import java.util.List;

class aaf implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ ej b;
    final /* synthetic */ ag c;
    final /* synthetic */ zo d;

    aaf(zo zoVar, List list, ej ejVar, ag agVar) {
        this.d = zoVar;
        this.a = list;
        this.b = ejVar;
        this.c = agVar;
    }

    public void run() {
        this.d.P.addAll(this.a);
        this.b.a(this.a, this.d.N.b() ? ((Boolean) this.d.N.a()).booleanValue() : true, new aag(this));
    }
}
