package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.o;
import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.domain.account.ab;

class hb extends r {
    b a = new b();
    final ab b = new ab(this.c.d.c());
    final /* synthetic */ PersonalPrefs c;

    hb(PersonalPrefs personalPrefs) {
        this.c = personalPrefs;
    }

    protected void onSessionTry() {
        this.a = new o(this, this.b).c();
    }

    protected void onSessionSucceeded() {
        if (this.a.b == 0 && this.c.a(this.b)) {
            this.c.a((String) this.a.a);
        }
    }

    protected void onSessionFailed() {
    }
}
