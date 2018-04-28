package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0640n;
import com.duokan.reader.domain.account.al;

class gg extends WebSession {
    /* renamed from: a */
    C0621a<Void> f4047a = new C0621a();
    /* renamed from: b */
    final al f4048b = new al(this.f4050d.f3632d.m3508d());
    /* renamed from: c */
    final /* synthetic */ String f4049c;
    /* renamed from: d */
    final /* synthetic */ PersonalPrefs f4050d;

    gg(PersonalPrefs personalPrefs, C0657i c0657i, String str) {
        this.f4050d = personalPrefs;
        this.f4049c = str;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f4047a = new C0640n(this, this.f4048b).m2926i(this.f4049c);
    }

    protected void onSessionSucceeded() {
        if (this.f4047a.b == 0 || !this.f4050d.m5209a(this.f4048b)) {
            this.f4050d.m5194j(false);
        } else {
            this.f4050d.m5194j(true);
        }
    }

    protected void onSessionFailed() {
        if (this.f4050d.m5209a(this.f4048b)) {
            this.f4050d.m5194j(true);
        }
    }
}
