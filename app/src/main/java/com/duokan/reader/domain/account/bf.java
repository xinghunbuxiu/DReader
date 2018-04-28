package com.duokan.reader.domain.account;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.social.p048b.C1134a;

class bf extends WebSession {
    /* renamed from: a */
    final /* synthetic */ String f2414a;
    /* renamed from: b */
    final /* synthetic */ ba f2415b;
    /* renamed from: c */
    final /* synthetic */ MiGuestAccount f2416c;
    /* renamed from: d */
    private C0621a<Void> f2417d = null;

    bf(MiGuestAccount miGuestAccount, String str, ba baVar) {
        this.f2416c = miGuestAccount;
        this.f2414a = str;
        this.f2415b = baVar;
    }

    protected void onSessionTry() {
        this.f2417d = new C1134a(this, C0709k.m3476a().m3508d()).m8456e(this.f2414a);
    }

    protected void onSessionSucceeded() {
        if (this.f2417d.b == 0) {
            this.f2416c.f2263j.f2427d.f5468i = this.f2414a;
            this.f2416c.m3155l();
            this.f2416c.a.mo881c(this.f2416c);
            this.f2415b.mo1588a();
            return;
        }
        this.f2415b.mo1589a(this.f2417d.b, this.f2417d.c);
    }

    protected void onSessionFailed() {
        this.f2415b.mo1589a(this.f2417d.b, this.f2417d.c);
    }
}
