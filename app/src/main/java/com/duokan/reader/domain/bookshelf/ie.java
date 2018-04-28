package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;

class ie extends WebSession {
    /* renamed from: a */
    final /* synthetic */ hc f3344a;

    ie(hc hcVar, C0657i c0657i) {
        this.f3344a = hcVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f3344a.m3946u();
        this.f3344a.m3915b(this.f3344a.m3806F(), true);
    }

    protected void onSessionSucceeded() {
        this.f3344a.m3949x();
    }

    protected void onSessionFailed() {
        this.f3344a.m3949x();
    }
}
