package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.al;

class bx extends WebSession {
    /* renamed from: a */
    final /* synthetic */ al f2876a;
    /* renamed from: b */
    final /* synthetic */ bw f2877b;

    bx(bw bwVar, C0657i c0657i, al alVar) {
        this.f2877b = bwVar;
        this.f2876a = alVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        new bq(this.f2876a).m4053a();
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }
}
