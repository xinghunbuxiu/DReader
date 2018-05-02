package com.duokan.reader.domain.store;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0647u;
import com.duokan.reader.domain.account.PersonalAccount;

/* renamed from: com.duokan.reader.domain.store.e */
class C1180e extends WebSession {
    /* renamed from: a */
    final /* synthetic */ String f5657a;
    /* renamed from: b */
    final /* synthetic */ C1185k f5658b;
    /* renamed from: c */
    final /* synthetic */ C1176a f5659c;
    /* renamed from: d */
    private C0621a<String[]> f5660d = new C0621a();

    C1180e(C1176a c1176a, C0657i c0657i, String str, C1185k c1185k) {
        this.f5659c = c1176a;
        this.f5657a = str;
        this.f5658b = c1185k;
        super(c0657i);
    }

    protected void onSessionTry() {
        try {
            this.f5660d = new C0647u(this, this.f5659c.f5631b.m3502b(PersonalAccount.class)).m3041f(this.f5657a);
        } catch (Throwable th) {
        }
        if (this.f5660d.f2058a == null || ((String[]) this.f5660d.f2058a).length < 1) {
            Object obj = new String[]{this.f5657a};
            this.f5660d.f2058a = obj;
        }
    }

    protected void onSessionSucceeded() {
        this.f5658b.mo1858a(this.f5657a, (String[]) this.f5660d.f2058a);
        this.f5659c.f5633f = null;
    }

    protected void onSessionFailed() {
        this.f5658b.mo1857a("");
        this.f5659c.f5633f = null;
    }
}
