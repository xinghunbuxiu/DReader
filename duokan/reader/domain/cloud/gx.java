package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.o;
import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.ab;

class gx extends r {
    b a = new b();
    final ab b = new ab(this.c.d.b(PersonalAccount.class));
    final /* synthetic */ PersonalPrefs c;

    gx(PersonalPrefs personalPrefs) {
        this.c = personalPrefs;
    }

    protected void onSessionTry() {
        this.a = new o(this, this.b).a(this.c.b());
    }

    protected void onSessionSucceeded() {
        if (this.a.b == 0 && this.c.a(this.b) && ((Integer) this.a.a).intValue() > 0) {
            this.c.a(((Integer) this.a.a).intValue(), false);
        }
    }

    protected void onSessionFailed() {
    }
}
