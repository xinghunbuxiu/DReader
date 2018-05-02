package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.o;
import com.duokan.reader.domain.account.ab;

class ha extends hf {
    b a = new b();
    final ab b = new ab(this.d.d.c());
    final /* synthetic */ String c;
    final /* synthetic */ PersonalPrefs d;

    ha(PersonalPrefs personalPrefs, String str) {
        this.d = personalPrefs;
        this.c = str;
        super(personalPrefs);
    }

    protected void onSessionTry() {
        this.a = new o(this, this.b).i(this.c);
    }

    protected void onSessionSucceeded() {
        if (this.a.b == 0 || !this.d.a(this.b)) {
            this.d.j(false);
        } else {
            this.d.j(true);
        }
    }

    protected void onSessionFailed() {
        if (this.d.a(this.b)) {
            this.d.j(true);
        }
    }
}
