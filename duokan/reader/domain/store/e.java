package com.duokan.reader.domain.store;

import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.c;
import com.duokan.reader.common.webservices.duokan.v;
import com.duokan.reader.domain.account.PersonalAccount;

class e extends c {
    final /* synthetic */ String a;
    final /* synthetic */ k b;
    final /* synthetic */ a c;
    private b d = new b();

    e(a aVar, String str, k kVar) {
        this.c = aVar;
        this.a = str;
        this.b = kVar;
    }

    protected void onSessionTry() {
        try {
            this.d = new v(this, this.c.b.b(PersonalAccount.class)).f(this.a);
        } catch (Throwable th) {
        }
        if (this.d.a == null || ((String[]) this.d.a).length < 1) {
            Object obj = new String[]{this.a};
            this.d.a = obj;
        }
    }

    protected void onSessionSucceeded() {
        this.b.a(this.a, (String[]) this.d.a);
    }

    protected void onSessionFailed() {
    }
}
