package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.ac;
import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.ab;

class gr extends r {
    b a = new b();
    final /* synthetic */ String b;
    final /* synthetic */ gn c;

    gr(gn gnVar, String str) {
        this.c = gnVar;
        this.b = str;
    }

    protected void onSessionTry() {
        this.a = new ac(this, new ab(this.c.c.b(PersonalAccount.class))).a("400", this.b);
    }

    protected void onSessionSucceeded() {
        if (this.a.b == 0 || this.a.b == 150003 || this.a.b == 150004) {
            PersonalPrefs.a().c(true);
        }
    }

    protected void onSessionFailed() {
    }
}
