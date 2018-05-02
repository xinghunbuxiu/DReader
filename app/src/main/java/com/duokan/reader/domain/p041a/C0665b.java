package com.duokan.reader.domain.p041a;

import com.duokan.p023b.C0247i;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0635i;
import com.duokan.reader.common.webservices.duokan.C0640n;

/* renamed from: com.duokan.reader.domain.a.b */
class C0665b extends WebSession {
    /* renamed from: a */
    final /* synthetic */ String f2223a;
    /* renamed from: b */
    final /* synthetic */ C0670f f2224b;
    /* renamed from: c */
    final /* synthetic */ C0664a f2225c;
    /* renamed from: d */
    private C0621a<Integer> f2226d = null;
    /* renamed from: e */
    private C0621a<String> f2227e = null;

    C0665b(C0664a c0664a, C0657i c0657i, String str, C0670f c0670f) {
        this.f2225c = c0664a;
        this.f2223a = str;
        this.f2224b = c0670f;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f2227e = new C0640n(this, null).m2924g(this.f2223a);
        this.f2226d = new C0635i(this, this.f2225c.f2221d.m3508d()).m2875f((String) this.f2227e.f2058a);
    }

    protected void onSessionSucceeded() {
        this.f2224b.mo2509a(((Integer) this.f2226d.f2058a).intValue());
    }

    protected void onSessionFailed() {
        this.f2224b.mo2510a(this.f2225c.f2220c.getString(C0247i.general__shared__network_error));
    }
}
