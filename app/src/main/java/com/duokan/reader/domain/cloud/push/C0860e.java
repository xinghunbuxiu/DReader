package com.duokan.reader.domain.cloud.push;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0639m;
import com.duokan.reader.domain.account.C0672a;

/* renamed from: com.duokan.reader.domain.cloud.push.e */
class C0860e extends WebSession {
    /* renamed from: a */
    final /* synthetic */ C0672a f4116a;
    /* renamed from: b */
    final /* synthetic */ String f4117b;
    /* renamed from: c */
    final /* synthetic */ String[] f4118c;
    /* renamed from: d */
    final /* synthetic */ C0857b f4119d;
    /* renamed from: e */
    private C0621a<Boolean> f4120e;

    C0860e(C0857b c0857b, C0657i c0657i, C0672a c0672a, String str, String[] strArr) {
        this.f4119d = c0857b;
        this.f4116a = c0672a;
        this.f4117b = str;
        this.f4118c = strArr;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f4120e = new C0639m((WebSession) this, this.f4116a).m2903a(this.f4117b, this.f4118c);
        if (((Boolean) this.f4120e.f2058a).booleanValue()) {
            C0872q.m5709b().m5720f();
        }
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }
}
