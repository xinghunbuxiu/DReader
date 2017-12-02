package com.duokan.reader.domain.account;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.domain.social.b.a;

class bj extends WebSession {
    final /* synthetic */ String a;
    final /* synthetic */ bb b;
    final /* synthetic */ MiGuestAccount c;
    private b d = null;

    bj(MiGuestAccount miGuestAccount, String str, bb bbVar) {
        this.c = miGuestAccount;
        this.a = str;
        this.b = bbVar;
    }

    protected void onSessionTry() {
        this.d = new a(this, i.f().c()).e(this.a);
    }

    protected void onSessionSucceeded() {
        if (this.d.b == 0) {
            this.c.j.d.i = this.a;
            this.c.l();
            this.c.a.c(this.c);
            this.b.a();
            return;
        }
        this.b.a(this.d.b, this.d.c);
    }

    protected void onSessionFailed() {
        this.b.a(this.d.b, this.d.c);
    }
}
