package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.o;
import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.i;

class eo extends r {
    final /* synthetic */ ab a;
    final /* synthetic */ en b;
    private b c;

    eo(en enVar, ab abVar) {
        this.b = enVar;
        this.a = abVar;
    }

    protected void onSessionOpen() {
        super.onSessionOpen();
        this.b.a.a();
    }

    protected void onSessionTry() {
        this.c = new o(this, this.a).f(this.b.b);
    }

    protected void onSessionSucceeded() {
        if (!this.a.a(this.b.c.f)) {
            this.b.a.a("");
        } else if (this.c.b == 1001 || this.c.b == 1002 || this.c.b == 1003) {
            i.f().a(this.a.a, new ep(this));
        } else if (this.c.b != 0) {
            this.b.a.a(this.c.c);
        } else {
            this.b.c.b();
            this.b.a.b();
        }
    }

    protected void onSessionFailed() {
        if (this.a.a(this.b.c.f)) {
            this.b.a.a(this.b.c.b.getString(com.duokan.b.i.general__shared__network_error));
        } else {
            this.b.a.a("");
        }
    }
}
