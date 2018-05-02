package com.duokan.reader.domain.account;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.domain.social.b.a;
import com.duokan.reader.domain.social.b.c;

class bk extends WebSession {
    final /* synthetic */ d a;
    final /* synthetic */ MiGuestAccount b;
    private b c = null;

    bk(MiGuestAccount miGuestAccount, d dVar) {
        this.b = miGuestAccount;
        this.a = dVar;
    }

    protected void onSessionTry() {
        this.c = new a(this, this.b).f(this.b.g);
    }

    protected void onSessionSucceeded() {
        if (this.c.b == 0) {
            this.b.j.d.a((c) this.c.a);
            this.b.l();
            this.b.a.c(this.b);
            if (this.a != null) {
                this.a.a(this.b);
            }
        } else if (this.a != null) {
            this.a.a(this.b, "");
        }
    }

    protected void onSessionFailed() {
        this.a.a(this.b, "");
    }
}
