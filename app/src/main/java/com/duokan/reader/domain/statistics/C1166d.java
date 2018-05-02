package com.duokan.reader.domain.statistics;

import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0645s;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.al;

/* renamed from: com.duokan.reader.domain.statistics.d */
class C1166d extends WebSession {
    /* renamed from: a */
    final /* synthetic */ C1165c f5607a;

    C1166d(C1165c c1165c, C0657i c0657i) {
        this.f5607a = c1165c;
        super(c0657i);
    }

    protected void onSessionTry() {
        C0645s c0645s = new C0645s(this, new al(C0709k.m3476a().m3502b(PersonalAccount.class)));
        while (!this.f5607a.f5606a.f5594f.isEmpty()) {
            c0645s.m3008e((String) this.f5607a.f5606a.f5594f.element());
            this.f5607a.f5606a.f5594f.remove();
        }
        while (!this.f5607a.f5606a.f5595g.isEmpty()) {
            C1174h c1174h = (C1174h) this.f5607a.f5606a.f5595g.element();
            c0645s.m3007a(c1174h.f5624a, c1174h.f5625b, c1174h.f5626c);
            this.f5607a.f5606a.f5595g.remove();
        }
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }
}
