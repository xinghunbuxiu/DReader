package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.e;

class cr implements Runnable {
    final /* synthetic */ e a;
    final /* synthetic */ int b;
    final /* synthetic */ co c;

    cr(co coVar, e eVar, int i) {
        this.c = coVar;
        this.a = eVar;
        this.b = i;
    }

    public void run() {
        as aa = this.c.a.aa();
        aa.E();
        if (!aa.l().a(this.a.a())) {
            this.c.a.a(this.a.a());
            aa = this.c.a.aa();
        }
        this.c.d.a(this.c.e.a(this.b), aa.u(this.b - aa.v(0)), new cs(this));
    }
}
