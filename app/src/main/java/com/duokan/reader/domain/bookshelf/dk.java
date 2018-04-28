package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.al;

class dk extends WebSession {
    /* renamed from: a */
    final /* synthetic */ al f3030a;
    /* renamed from: b */
    final /* synthetic */ dw f3031b;
    /* renamed from: c */
    final /* synthetic */ de f3032c;
    /* renamed from: d */
    private dc f3033d;

    dk(de deVar, C0657i c0657i, al alVar, dw dwVar) {
        this.f3032c = deVar;
        this.f3030a = alVar;
        this.f3031b = dwVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        da daVar = new da(this.f3030a);
        daVar.m4295a();
        this.f3033d = daVar.m4296b();
    }

    protected void onSessionSucceeded() {
        if (this.f3030a.m3365a(this.f3032c.f3011c)) {
            this.f3032c.m4316a(this.f3033d, new dl(this));
            return;
        }
        this.f3031b.mo982a("");
        m4345a();
    }

    protected void onSessionFailed() {
        this.f3031b.mo982a("");
        m4345a();
    }

    /* renamed from: a */
    private void m4345a() {
        this.f3032c.f3015g.poll();
        this.f3032c.m4331d();
    }
}
