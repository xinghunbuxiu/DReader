package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.o;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.ab;

class gy extends hf {
    b a = new b();
    final ab b = new ab(this.e.d.b(PersonalAccount.class));
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ PersonalPrefs e;

    gy(PersonalPrefs personalPrefs, int i, int i2) {
        this.e = personalPrefs;
        this.c = i;
        this.d = i2;
        super(personalPrefs);
    }

    protected void onSessionTry() {
        this.a = new o(this, this.b).b(this.c, this.d);
    }

    protected void onSessionSucceeded() {
        if (this.a.b == 0 || !this.e.a(this.b)) {
            this.e.i(false);
        } else {
            this.e.i(true);
        }
    }

    protected void onSessionFailed() {
        if (this.e.a(this.b)) {
            this.e.i(true);
        }
    }
}
