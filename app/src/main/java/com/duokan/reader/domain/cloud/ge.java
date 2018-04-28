package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0640n;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.al;

class ge extends WebSession {
    /* renamed from: a */
    C0621a<Void> f4039a = new C0621a();
    /* renamed from: b */
    final al f4040b = new al(this.f4043e.f3632d.m3502b(PersonalAccount.class));
    /* renamed from: c */
    final /* synthetic */ int f4041c;
    /* renamed from: d */
    final /* synthetic */ int f4042d;
    /* renamed from: e */
    final /* synthetic */ PersonalPrefs f4043e;

    ge(PersonalPrefs personalPrefs, C0657i c0657i, int i, int i2) {
        this.f4043e = personalPrefs;
        this.f4041c = i;
        this.f4042d = i2;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f4039a = new C0640n(this, this.f4040b).m2918b(this.f4041c, this.f4042d);
    }

    protected void onSessionSucceeded() {
        if (this.f4039a.b == 0 || !this.f4043e.m5209a(this.f4040b)) {
            this.f4043e.m5193i(false);
        } else {
            this.f4043e.m5193i(true);
        }
    }

    protected void onSessionFailed() {
        if (this.f4043e.m5209a(this.f4040b)) {
            this.f4043e.m5193i(true);
        }
    }
}
