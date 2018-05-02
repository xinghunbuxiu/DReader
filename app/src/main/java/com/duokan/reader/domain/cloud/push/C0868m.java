package com.duokan.reader.domain.cloud.push;

import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.p025a.C0345c;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0639m;
import com.duokan.reader.domain.account.C0672a;

/* renamed from: com.duokan.reader.domain.cloud.push.m */
class C0868m extends WebSession {
    /* renamed from: a */
    final /* synthetic */ C0672a f4133a;
    /* renamed from: b */
    final /* synthetic */ String f4134b;
    /* renamed from: c */
    final /* synthetic */ String f4135c;
    /* renamed from: d */
    final /* synthetic */ Runnable f4136d;
    /* renamed from: e */
    final /* synthetic */ C0857b f4137e;
    /* renamed from: f */
    private C0621a<Boolean> f4138f;

    C0868m(C0857b c0857b, C0657i c0657i, C0672a c0672a, String str, String str2, Runnable runnable) {
        this.f4137e = c0857b;
        this.f4133a = c0672a;
        this.f4134b = str;
        this.f4135c = str2;
        this.f4136d = runnable;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f4138f = new C0639m((WebSession) this, this.f4133a).m2900a(this.f4134b, C0345c.m830a());
    }

    protected void onSessionSucceeded() {
        WebLog.init().c(LogLevel.EVENT, "push", "add push token to DkServer succeed");
        if (((Boolean) this.f4138f.f2058a).booleanValue()) {
            this.f4137e.f4106g.setPrefString(PrivatePref.PERSONAL, "mi_push_token", this.f4134b);
            this.f4137e.f4106g.setPrefString(PrivatePref.PERSONAL, "mi_push_account", this.f4135c);
            if (this.f4133a != null) {
                this.f4137e.f4106g.setPrefString(PrivatePref.PERSONAL, "mi_push_account_token", this.f4133a.mo834d());
            }
            this.f4137e.f4106g.setPrefLong(PrivatePref.PERSONAL, "mi_push_register_time", System.currentTimeMillis());
            this.f4137e.f4106g.commitPrefs();
            if (this.f4136d != null) {
                this.f4136d.run();
            }
        }
    }

    protected void onSessionFailed() {
    }
}
