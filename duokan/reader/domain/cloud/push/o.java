package com.duokan.reader.domain.cloud.push;

import com.duokan.reader.common.webservices.duokan.m;
import com.duokan.reader.common.webservices.duokan.n;
import com.duokan.reader.domain.account.a;

class o extends n {
    final /* synthetic */ String a;
    final /* synthetic */ b b;

    o(b bVar, String str) {
        this.b = bVar;
        this.a = str;
    }

    protected void onSessionTry() {
        t.b().g();
        if (((Boolean) new m((n) this, (a) null).f(this.a).a).booleanValue()) {
            this.b.g();
        }
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }
}
