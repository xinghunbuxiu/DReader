package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.o;
import com.duokan.reader.domain.account.ab;

class hc extends hf {
    b a = new b();
    final ab b = new ab(this.c.d.c());
    final /* synthetic */ PersonalPrefs c;

    hc(PersonalPrefs personalPrefs) {
        this.c = personalPrefs;
        super(personalPrefs);
    }

    protected void onSessionTry() {
        this.a = new o(this, this.b).d();
    }

    protected void onSessionSucceeded() {
        if (this.a.b != 0 || !this.c.a(this.b)) {
            return;
        }
        if (((Integer) this.a.a).intValue() != 0) {
            this.c.b(((Integer) this.a.a).intValue(), false);
        } else if (this.c.g() > 0) {
            this.c.D();
        }
    }

    protected void onSessionFailed() {
    }

    protected void onSessionClosed() {
        this.c.C();
    }
}
