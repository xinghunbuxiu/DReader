package com.duokan.reader.ui.account.p050a;

import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;

/* renamed from: com.duokan.reader.ui.account.a.b */
class C1237b extends WebSession {
    /* renamed from: a */
    boolean f5750a = false;
    /* renamed from: b */
    final /* synthetic */ C1239d f5751b;
    /* renamed from: c */
    final /* synthetic */ C1236a f5752c;

    C1237b(C1236a c1236a, C0657i c0657i, C1239d c1239d) {
        this.f5752c = c1236a;
        this.f5751b = c1239d;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f5750a = new C1242g(this).m8836b();
    }

    protected void onSessionSucceeded() {
        this.f5751b.mo1561a();
    }

    protected void onSessionFailed() {
        this.f5751b.mo1564b();
    }
}
