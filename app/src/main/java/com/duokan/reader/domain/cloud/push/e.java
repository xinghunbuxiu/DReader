package com.duokan.reader.domain.cloud.push;

import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.m;
import com.duokan.reader.common.webservices.duokan.n;
import com.duokan.reader.domain.account.a;

class e extends n {
    final /* synthetic */ a a;
    final /* synthetic */ String b;
    final /* synthetic */ String[] c;
    final /* synthetic */ b d;
    private b e;

    e(b bVar, a aVar, String str, String[] strArr) {
        this.d = bVar;
        this.a = aVar;
        this.b = str;
        this.c = strArr;
    }

    protected void onSessionTry() {
        this.e = new m((n) this, this.a).a(this.b, this.c);
        if (((Boolean) this.e.a).booleanValue()) {
            t.b().f();
        }
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }
}
