package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0652z;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.ReloginSession;
import com.wali.live.sdk.manager.IMiLiveSdk.ICallback;

class fb extends ReloginSession {
    /* renamed from: a */
    final /* synthetic */ C0672a f3978a;
    /* renamed from: b */
    final /* synthetic */ fa f3979b;
    /* renamed from: c */
    private C0621a<Void> f3980c = null;

    fb(fa faVar, String str, C0657i c0657i, C0672a c0672a) {
        this.f3979b = faVar;
        this.f3978a = c0672a;
        super(str, c0657i);
    }

    /* renamed from: a */
    public void mo825a() {
        this.f3980c = new C0652z((WebSession) this, this.f3978a).m3072d(this.f3979b.f3974a.getLinkUrl(), this.f3979b.f3975b);
    }

    /* renamed from: b */
    public void mo827b() {
        if (this.f3980c == null || this.f3980c.b != 0) {
            this.f3979b.f3976c.mo1928a(this.f3980c.c);
            return;
        }
        this.f3979b.f3974a.setMessage(this.f3979b.f3975b);
        this.f3979b.f3976c.mo1927a(this.f3979b.f3974a);
    }

    /* renamed from: a */
    public void mo826a(String str) {
        this.f3979b.f3976c.mo1928a(str);
    }

    /* renamed from: c */
    public boolean mo828c() {
        return this.f3980c.b == 1001 || this.f3980c.b == ICallback.LOGIN_OAUTH_AIDL || this.f3980c.b == ICallback.CLEAR_ACCOUNT_AIDL;
    }
}
