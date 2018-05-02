package com.duokan.reader.domain.statistics;

import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0628a;
import com.duokan.reader.common.webservices.duokan.C0645s;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.al;

/* renamed from: com.duokan.reader.domain.statistics.f */
class C1172f extends WebSession {
    /* renamed from: a */
    final /* synthetic */ C1171e f5620a;

    C1172f(C1171e c1171e, C0657i c0657i) {
        this.f5620a = c1171e;
        super(c0657i);
    }

    protected void onSessionTry() {
        C0645s c0645s = new C0645s(this, new al(C0709k.m3476a().m3502b(PersonalAccount.class)));
        while (!this.f5620a.f5619a.f5596h.isEmpty()) {
            c0645s.m3005a((C0628a) this.f5620a.f5619a.f5596h.poll());
        }
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }
}
