package com.duokan.reader.domain.ad;

import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.common.webservices.C0237c;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.p040a.C0627d;
import org.apache.http.protocol.HTTP;

/* renamed from: com.duokan.reader.domain.ad.n */
class C0757n extends WebSession {
    /* renamed from: a */
    C0621a<String> f2571a = new C0621a();
    /* renamed from: b */
    final /* synthetic */ String f2572b;
    /* renamed from: c */
    final /* synthetic */ int f2573c;
    /* renamed from: d */
    final /* synthetic */ C0759p f2574d;
    /* renamed from: e */
    final /* synthetic */ C0750g f2575e;

    C0757n(C0750g c0750g, String str, int i, C0759p c0759p) {
        this.f2575e = c0750g;
        this.f2572b = str;
        this.f2573c = i;
        this.f2574d = c0759p;
    }

    protected void onSessionTry() {
        C0627d execute = execute(new C0760q().m3602a("http://api.ad.xiaomi.com/u/api").m3604b(this.f2572b).m3605c("2.0").m3601a(this.f2573c).m3600a());
        this.f2571a.f2058a = new C0237c(this).m550b(execute, HTTP.UTF_8);
    }

    protected boolean onSessionException(Exception exception, int i) {
        WebLog.init().c(LogLevel.ERROR, "ads", "fetching ads exception");
        return super.onSessionException(exception, i);
    }

    protected void onSessionSucceeded() {
        this.f2574d.mo1848a((String) this.f2571a.f2058a);
    }

    protected void onSessionFailed() {
        this.f2574d.mo1847a();
    }
}
