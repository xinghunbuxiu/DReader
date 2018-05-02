package com.duokan.reader.ui.reading;

import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.common.webservices.duokan.t;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.bookshelf.c;

class re extends r {
    final /* synthetic */ c a;
    final /* synthetic */ rd b;

    re(rd rdVar, c cVar) {
        this.b = rdVar;
        this.a = cVar;
    }

    protected void onSessionTry() {
        t tVar = new t(this, new ab(i.f().b(PersonalAccount.class)));
        int i = 1;
        if (this.b.a.aj()) {
            i = 4;
        } else if (this.b.a.k()) {
            i = 2;
        }
        tVar.a(this.a.ap(), i);
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }
}
