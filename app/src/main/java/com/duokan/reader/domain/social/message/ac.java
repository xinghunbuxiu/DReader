package com.duokan.reader.domain.social.message;

import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.al;

class ac extends WebSession {
    /* renamed from: a */
    final /* synthetic */ al f5485a;
    /* renamed from: b */
    final /* synthetic */ DkMessagesManager f5486b;
    /* renamed from: c */
    private DkMessagesInfo f5487c = null;

    ac(DkMessagesManager dkMessagesManager, C0657i c0657i, al alVar) {
        this.f5486b = dkMessagesManager;
        this.f5485a = alVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        synchronized (DkMessagesManager.f5470a) {
            aq aqVar = new aq(this.f5486b.f5474e, this.f5485a, this.f5486b.f5475f);
            aqVar.m8529a();
            this.f5487c = aqVar.m8530b();
        }
    }

    protected void onSessionSucceeded() {
        if (this.f5486b.f5479j.m3365a(this.f5485a)) {
            this.f5486b.m8468a(this.f5487c.mUnreadMessageIds);
        }
    }

    protected void onSessionFailed() {
    }
}
