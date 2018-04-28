package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0640n;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.al;

class gd extends WebSession {
    /* renamed from: a */
    C0621a<Integer> f4036a = new C0621a();
    /* renamed from: b */
    final al f4037b = new al(this.f4038c.f3632d.m3502b(PersonalAccount.class));
    /* renamed from: c */
    final /* synthetic */ PersonalPrefs f4038c;

    gd(PersonalPrefs personalPrefs, C0657i c0657i) {
        this.f4038c = personalPrefs;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f4036a = new C0640n(this, this.f4037b).m2911a(this.f4038c.m5210b());
    }

    protected void onSessionSucceeded() {
        if (this.f4036a.b == 0 && this.f4038c.m5209a(this.f4037b) && ((Integer) this.f4036a.f2058a).intValue() > 0) {
            this.f4038c.m5199a(((Integer) this.f4036a.f2058a).intValue(), false);
        }
    }

    protected void onSessionFailed() {
    }
}
