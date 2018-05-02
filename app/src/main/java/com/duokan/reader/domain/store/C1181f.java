package com.duokan.reader.domain.store;

import com.duokan.p023b.C0247i;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0646t;
import com.duokan.reader.common.webservices.duokan.C0647u;
import com.duokan.reader.domain.account.PersonalAccount;

/* renamed from: com.duokan.reader.domain.store.f */
class C1181f extends WebSession {
    /* renamed from: a */
    final /* synthetic */ String f5661a;
    /* renamed from: b */
    final /* synthetic */ int f5662b;
    /* renamed from: c */
    final /* synthetic */ int f5663c;
    /* renamed from: d */
    final /* synthetic */ C1182g f5664d;
    /* renamed from: e */
    final /* synthetic */ C1176a f5665e;
    /* renamed from: f */
    private C0621a<C0646t[]> f5666f = null;

    C1181f(C1176a c1176a, C0657i c0657i, String str, int i, int i2, C1182g c1182g) {
        this.f5665e = c1176a;
        this.f5661a = str;
        this.f5662b = i;
        this.f5663c = i2;
        this.f5664d = c1182g;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f5666f = new C0647u(this, this.f5665e.f5631b.m3502b(PersonalAccount.class)).m3039b(this.f5661a, this.f5662b, this.f5663c);
    }

    protected void onSessionSucceeded() {
        this.f5664d.mo2538a((C0646t[]) this.f5666f.f2058a, Integer.valueOf(this.f5666f.c).intValue(), ((C0646t[]) this.f5666f.f2058a).length == this.f5663c);
    }

    protected void onSessionFailed() {
        this.f5664d.mo2537a(this.f5665e.f5630a.getString(C0247i.general__shared__network_error));
    }
}
