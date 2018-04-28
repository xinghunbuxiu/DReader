package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.ab;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.al;

class fx extends WebSession {
    /* renamed from: a */
    C0621a<Void> f4023a = new C0621a();
    /* renamed from: b */
    final /* synthetic */ String f4024b;
    /* renamed from: c */
    final /* synthetic */ ft f4025c;

    fx(ft ftVar, C0657i c0657i, String str) {
        this.f4025c = ftVar;
        this.f4024b = str;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f4023a = new ab(this, new al(this.f4025c.f4016c.m3502b(PersonalAccount.class))).m2866a("400", this.f4024b);
    }

    protected void onSessionSucceeded() {
        if (this.f4023a.b == 0 || this.f4023a.b == 150003 || this.f4023a.b == 150004) {
            PersonalPrefs.m5175a().m5221c(true);
        }
    }

    protected void onSessionFailed() {
    }
}
