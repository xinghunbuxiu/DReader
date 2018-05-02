package com.duokan.reader.ui.reading;

import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.ag;
import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.common.webservices.duokan.v;

class dx extends r {
    b a = new b();
    final /* synthetic */ eh b;
    final /* synthetic */ de c;

    dx(de deVar, eh ehVar) {
        this.c = deVar;
        this.b = ehVar;
    }

    protected void onSessionTry() {
        this.a = new v(this, this.b.a).g(this.c.F);
    }

    protected void onSessionSucceeded() {
        if (de.b.b(this.b) && this.a.b == 0) {
            this.b.g = (ag) this.a.a;
            de.b.a(this.b);
            this.c.b(this.b);
            this.c.c(this.b);
            this.c.g();
        }
    }

    protected void onSessionFailed() {
    }
}
