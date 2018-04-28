package com.duokan.reader.ui.reading;

import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0645s;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.bookshelf.C0800c;

class rp extends WebSession {
    /* renamed from: a */
    final /* synthetic */ C0800c f10908a;
    /* renamed from: b */
    final /* synthetic */ ro f10909b;

    rp(ro roVar, C0657i c0657i, C0800c c0800c) {
        this.f10909b = roVar;
        this.f10908a = c0800c;
        super(c0657i);
    }

    protected void onSessionTry() {
        C0645s c0645s = new C0645s(this, new al(C0709k.m3476a().m3502b(PersonalAccount.class)));
        int i = 1;
        if (this.f10909b.f10906a.al()) {
            i = 4;
        } else if (this.f10909b.f10906a.mo1038k()) {
            i = 2;
        }
        c0645s.m3006a(this.f10908a.ar(), i);
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }
}
