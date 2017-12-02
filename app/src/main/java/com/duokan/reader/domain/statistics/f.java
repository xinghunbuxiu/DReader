package com.duokan.reader.domain.statistics;

import com.duokan.reader.common.webservices.duokan.a;
import com.duokan.reader.common.webservices.duokan.t;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.i;

class f extends i {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
        super(eVar.a);
    }

    protected void onSessionTry() {
        t tVar = new t(this, new ab(i.f().b(PersonalAccount.class)));
        while (!this.a.a.h.isEmpty()) {
            tVar.a((a) this.a.a.h.poll());
        }
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }
}
