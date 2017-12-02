package com.duokan.reader.domain.cloud.push;

import com.duokan.reader.common.webservices.duokan.m;
import com.duokan.reader.domain.account.a;

class n extends com.duokan.reader.common.webservices.duokan.n {
    final /* synthetic */ String a;
    final /* synthetic */ b b;

    n(b bVar, String str) {
        this.b = bVar;
        this.a = str;
    }

    protected void onSessionTry() {
        t.b().g();
        if (((Boolean) new m((com.duokan.reader.common.webservices.duokan.n) this, (a) null).e(this.a).a).booleanValue()) {
            this.b.g();
        }
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }
}
