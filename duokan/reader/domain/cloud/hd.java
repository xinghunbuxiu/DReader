package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.duokan.o;
import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.domain.account.ab;

class hd extends r {
    final ab a = new ab(this.c.d.c());
    final /* synthetic */ int b;
    final /* synthetic */ PersonalPrefs c;

    hd(PersonalPrefs personalPrefs, int i) {
        this.c = personalPrefs;
        this.b = i;
    }

    protected void onSessionTry() {
        new o(this, this.a).c(this.b);
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }
}
