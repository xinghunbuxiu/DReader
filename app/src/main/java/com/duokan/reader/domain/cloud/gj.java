package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0640n;
import com.duokan.reader.domain.account.al;

class gj extends WebSession {
    /* renamed from: a */
    final al f4057a = new al(this.f4059c.f3632d.m3508d());
    /* renamed from: b */
    final /* synthetic */ int f4058b;
    /* renamed from: c */
    final /* synthetic */ PersonalPrefs f4059c;

    gj(PersonalPrefs personalPrefs, C0657i c0657i, int i) {
        this.f4059c = personalPrefs;
        this.f4058b = i;
        super(c0657i);
    }

    protected void onSessionTry() {
        new C0640n(this, this.f4057a).m2920c(this.f4058b);
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }
}
