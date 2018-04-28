package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.al;

class dh extends WebSession {
    /* renamed from: a */
    final /* synthetic */ al f3019a;
    /* renamed from: b */
    final /* synthetic */ dg f3020b;

    dh(dg dgVar, C0657i c0657i, al alVar) {
        this.f3020b = dgVar;
        this.f3019a = alVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        new da(this.f3019a).m4295a();
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }
}
