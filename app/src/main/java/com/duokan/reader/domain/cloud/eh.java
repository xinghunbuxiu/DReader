package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.al;

class eh extends WebSession {
    /* renamed from: a */
    final /* synthetic */ al f3923a;
    /* renamed from: b */
    final /* synthetic */ eg f3924b;

    eh(eg egVar, C0657i c0657i, al alVar) {
        this.f3924b = egVar;
        this.f3923a = alVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        new ev(this.f3923a).destroy();
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }
}
