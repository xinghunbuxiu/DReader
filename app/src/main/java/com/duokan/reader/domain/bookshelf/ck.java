package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;

class ck extends WebSession {
    /* renamed from: a */
    final /* synthetic */ cw f2965a;
    /* renamed from: b */
    final /* synthetic */ bu f2966b;
    /* renamed from: c */
    private bs f2967c;

    ck(bu buVar, C0657i c0657i, cw cwVar) {
        this.f2966b = buVar;
        this.f2965a = cwVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        if (this.f2965a.f2991b) {
            this.f2967c = new bs();
            return;
        }
        bq bqVar = new bq(this.f2965a.f2990a);
        bqVar.m4053a();
        this.f2967c = bqVar.m4054b();
    }

    protected void onSessionSucceeded() {
        if (this.f2965a.f2990a.m3365a(this.f2966b.f2868c)) {
            this.f2966b.m4080a(this.f2967c, new cl(this));
            return;
        }
        this.f2965a.f2992c.mo986a("");
        m4269a();
    }

    protected void onSessionFailed() {
        this.f2965a.f2992c.mo986a("");
        m4269a();
    }

    /* renamed from: a */
    private void m4269a() {
        this.f2966b.f2872g.poll();
        this.f2966b.m4099d();
    }
}
