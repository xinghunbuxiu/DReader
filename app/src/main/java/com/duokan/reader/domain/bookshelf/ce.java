package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.al;

class ce extends WebSession {
    /* renamed from: a */
    final /* synthetic */ al f2944a;
    /* renamed from: b */
    final /* synthetic */ ct f2945b;
    /* renamed from: c */
    final /* synthetic */ bu f2946c;
    /* renamed from: d */
    private final cp f2947d = new cp();

    ce(bu buVar, C0657i c0657i, al alVar, ct ctVar) {
        this.f2946c = buVar;
        this.f2944a = alVar;
        this.f2945b = ctVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        bq bqVar = new bq(this.f2944a);
        bqVar.m4053a();
        this.f2947d.m4278a(bqVar);
    }

    protected void onSessionSucceeded() {
        if (this.f2944a.m3365a(this.f2946c.f2868c)) {
            this.f2946c.m4088a(this.f2947d);
            if (this.f2945b != null) {
                this.f2945b.mo984a();
            }
        } else if (this.f2945b != null) {
            this.f2945b.mo985b();
        }
    }

    protected void onSessionFailed() {
        if (this.f2945b != null) {
            this.f2945b.mo985b();
        }
    }
}
