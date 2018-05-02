package com.duokan.reader.domain.cloud.push;

import com.duokan.p023b.C0247i;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0639m;
import com.duokan.reader.domain.account.C0672a;

/* renamed from: com.duokan.reader.domain.cloud.push.d */
class C0859d extends WebSession {
    /* renamed from: a */
    final /* synthetic */ C0672a f4110a;
    /* renamed from: b */
    final /* synthetic */ String f4111b;
    /* renamed from: c */
    final /* synthetic */ boolean f4112c;
    /* renamed from: d */
    final /* synthetic */ ag f4113d;
    /* renamed from: e */
    final /* synthetic */ C0857b f4114e;
    /* renamed from: f */
    private C0621a<Boolean> f4115f = null;

    C0859d(C0857b c0857b, C0657i c0657i, C0672a c0672a, String str, boolean z, ag agVar) {
        this.f4114e = c0857b;
        this.f4110a = c0672a;
        this.f4111b = str;
        this.f4112c = z;
        this.f4113d = agVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f4115f = new C0639m((WebSession) this, this.f4110a).m2901a(this.f4111b, this.f4112c);
        if (this.f4115f != null && ((Boolean) this.f4115f.f2058a).booleanValue()) {
            this.f4114e.f4106g.setPrefBoolean(PrivatePref.PERSONAL, "mi_push_notify_server", true);
            this.f4114e.f4106g.commitPrefs();
        }
    }

    protected void onSessionSucceeded() {
        if (this.f4115f == null || !((Boolean) this.f4115f.f2058a).booleanValue()) {
            this.f4113d.mo1183a(this.f4114e.f4103d.getString(C0247i.general__shared__push_server_error));
        } else {
            this.f4113d.mo1184a(this.f4112c);
        }
    }

    protected void onSessionFailed() {
        this.f4113d.mo1183a(this.f4114e.f4103d.getString(C0247i.general__shared__network_error));
    }
}
