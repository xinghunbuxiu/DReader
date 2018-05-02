package com.duokan.reader.domain.store;

import com.duokan.b.i;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.c;
import com.duokan.reader.common.webservices.duokan.u;
import com.duokan.reader.common.webservices.duokan.v;
import com.duokan.reader.domain.account.PersonalAccount;

class f extends c {
    final /* synthetic */ String a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ g d;
    final /* synthetic */ a e;
    private b f = null;

    f(a aVar, String str, int i, int i2, g gVar) {
        this.e = aVar;
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = gVar;
    }

    protected void onSessionTry() {
        this.f = new v(this, this.e.b.b(PersonalAccount.class)).b(this.a, this.b, this.c);
    }

    protected void onSessionSucceeded() {
        this.d.a((u[]) this.f.a, Integer.valueOf(this.f.c).intValue(), ((u[]) this.f.a).length == this.c);
    }

    protected void onSessionFailed() {
        this.d.a(this.e.a.getString(i.general__shared__network_error));
    }
}
