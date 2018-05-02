package com.duokan.reader.domain.cloud.push;

import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0639m;
import com.duokan.reader.domain.account.C0672a;

/* renamed from: com.duokan.reader.domain.cloud.push.n */
class C0869n extends WebSession {
    /* renamed from: a */
    final /* synthetic */ String f4139a;
    /* renamed from: b */
    final /* synthetic */ C0857b f4140b;

    C0869n(C0857b c0857b, C0657i c0657i, String str) {
        this.f4140b = c0857b;
        this.f4139a = str;
        super(c0657i);
    }

    protected void onSessionTry() {
        C0872q.m5709b().m5721g();
        if (((Boolean) new C0639m((WebSession) this, (C0672a) null).m2905e(this.f4139a).f2058a).booleanValue()) {
            this.f4140b.m5671g();
        }
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }
}
