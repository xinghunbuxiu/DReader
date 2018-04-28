package com.duokan.reader.domain.account;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.social.p048b.C1134a;
import com.duokan.reader.domain.social.p048b.C1136c;

class bg extends WebSession {
    /* renamed from: a */
    final /* synthetic */ C0700d f2418a;
    /* renamed from: b */
    final /* synthetic */ MiGuestAccount f2419b;
    /* renamed from: c */
    private C0621a<C1136c> f2420c = null;

    bg(MiGuestAccount miGuestAccount, C0700d c0700d) {
        this.f2419b = miGuestAccount;
        this.f2418a = c0700d;
    }

    protected void onSessionTry() {
        this.f2420c = new C1134a(this, this.f2419b).m8457f(this.f2419b.f2260g);
    }

    protected void onSessionSucceeded() {
        if (this.f2420c.b == 0) {
            this.f2419b.f2263j.f2427d.m8461a((C1136c) this.f2420c.f2058a);
            this.f2419b.m3155l();
            this.f2419b.a.mo881c(this.f2419b);
            if (this.f2418a != null) {
                this.f2418a.mo868a(this.f2419b);
            }
        } else if (this.f2418a != null) {
            this.f2418a.mo869a(this.f2419b, "");
        }
    }

    protected void onSessionFailed() {
        this.f2418a.mo869a(this.f2419b, "");
    }
}
