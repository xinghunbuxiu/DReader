package com.duokan.reader.ui.account.p050a;

import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;

/* renamed from: com.duokan.reader.ui.account.a.c */
class C1238c extends WebSession {
    /* renamed from: a */
    C1243h f5753a = null;
    /* renamed from: b */
    final /* synthetic */ C1239d f5754b;
    /* renamed from: c */
    final /* synthetic */ C1236a f5755c;

    C1238c(C1236a c1236a, C0657i c0657i, C1239d c1239d) {
        this.f5755c = c1236a;
        this.f5754b = c1239d;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f5753a = new C1242g(this).m8834a();
    }

    protected void onSessionSucceeded() {
        if (this.f5753a == null) {
            this.f5754b.mo1561a();
        } else if (this.f5753a.m8837a()) {
            this.f5754b.mo1563a(this.f5753a.m8838b());
        } else {
            this.f5754b.mo1561a();
        }
    }

    protected void onSessionFailed() {
        this.f5754b.mo1561a();
    }
}
