package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0640n;
import com.duokan.reader.domain.account.al;

class gi extends WebSession {
    /* renamed from: a */
    C0621a<Integer> f4054a = new C0621a();
    /* renamed from: b */
    final al f4055b = new al(this.f4056c.f3632d.m3508d());
    /* renamed from: c */
    final /* synthetic */ PersonalPrefs f4056c;

    gi(PersonalPrefs personalPrefs, C0657i c0657i) {
        this.f4056c = personalPrefs;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f4054a = new C0640n(this, this.f4055b).m2921d();
    }

    protected void onSessionSucceeded() {
        if (this.f4054a.b != 0 || !this.f4056c.m5209a(this.f4055b)) {
            return;
        }
        if (((Integer) this.f4054a.f2058a).intValue() != 0) {
            this.f4056c.m5212b(((Integer) this.f4054a.f2058a).intValue(), false);
        } else if (this.f4056c.m5229g() > 0) {
            this.f4056c.m5163E();
        }
    }

    protected void onSessionFailed() {
    }

    protected void onSessionClosed() {
        this.f4056c.m5162D();
    }
}
