package com.duokan.reader.ui.bookshelf;

import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0640n;
import com.duokan.reader.domain.store.C0466h;
import com.duokan.reader.domain.store.C1176a;
import com.duokan.reader.ui.general.be;

class cc extends WebSession {
    /* renamed from: a */
    C0621a<String[]> f6245a = new C0621a();
    /* renamed from: b */
    final /* synthetic */ String f6246b;
    /* renamed from: c */
    final /* synthetic */ ReaderFeature f6247c;
    /* renamed from: d */
    final /* synthetic */ bp f6248d;

    cc(bp bpVar, C0657i c0657i, String str, ReaderFeature readerFeature) {
        this.f6248d = bpVar;
        this.f6246b = str;
        this.f6247c = readerFeature;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f6245a = new C0640n(this, null).m2922e(this.f6246b);
    }

    protected void onSessionSucceeded() {
        int parseInt = Integer.parseInt(((String[]) this.f6245a.f2058a)[0]);
        String str = ((String[]) this.f6245a.f2058a)[1];
        C0466h cdVar = new cd(this);
        if (parseInt == 1 || parseInt == 3) {
            C1176a.m8695a().m8703a(str, false, cdVar);
        } else if (parseInt == 2) {
            C1176a.m8695a().m8705b(str, true, cdVar);
        }
    }

    protected void onSessionFailed() {
        be.m10286a(this.f6248d.getContext(), C0258j.reading__shared__fail_to_open_book, 0).show();
    }
}
