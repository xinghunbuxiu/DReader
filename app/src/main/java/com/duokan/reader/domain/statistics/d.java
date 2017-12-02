package com.duokan.reader.domain.statistics;

import com.duokan.reader.common.webservices.duokan.t;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.i;

class d extends i {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
        super(cVar.a);
    }

    protected void onSessionTry() {
        t tVar = new t(this, new ab(i.f().b(PersonalAccount.class)));
        while (!this.a.a.f.isEmpty()) {
            tVar.e((String) this.a.a.f.element());
            this.a.a.f.remove();
        }
        while (!this.a.a.g.isEmpty()) {
            h hVar = (h) this.a.a.g.element();
            tVar.a(hVar.a, hVar.b);
            this.a.a.g.remove();
        }
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }
}
