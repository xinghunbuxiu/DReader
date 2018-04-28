package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.al;

class di extends WebSession {
    /* renamed from: a */
    final /* synthetic */ al f3021a;
    /* renamed from: b */
    final /* synthetic */ du f3022b;
    /* renamed from: c */
    final /* synthetic */ de f3023c;
    /* renamed from: d */
    private final dv f3024d = new dv();

    di(de deVar, C0657i c0657i, al alVar, du duVar) {
        this.f3023c = deVar;
        this.f3021a = alVar;
        this.f3022b = duVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        da daVar = new da(this.f3021a);
        daVar.m4295a();
        this.f3024d.m4372a(daVar);
    }

    protected void onSessionSucceeded() {
        if (this.f3021a.m3365a(this.f3023c.f3011c)) {
            this.f3023c.m4321a(this.f3024d);
            if (this.f3022b != null) {
                this.f3022b.mo980a();
            }
        } else if (this.f3022b != null) {
            this.f3022b.mo981b();
        }
    }

    protected void onSessionFailed() {
        if (this.f3022b != null) {
            this.f3022b.mo981b();
        }
    }
}
