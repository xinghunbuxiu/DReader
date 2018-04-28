package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.duokan.C0640n;
import com.duokan.reader.domain.account.ReloginSession;
import com.duokan.reader.domain.account.al;
import com.wali.live.sdk.manager.IMiLiveSdk.ICallback;

class dz extends ReloginSession {
    /* renamed from: a */
    final /* synthetic */ al f3898a;
    /* renamed from: b */
    final /* synthetic */ dy f3899b;
    /* renamed from: c */
    private C0621a<Void> f3900c;

    dz(dy dyVar, String str, C0657i c0657i, al alVar) {
        this.f3899b = dyVar;
        this.f3898a = alVar;
        super(str, c0657i);
    }

    protected void onSessionOpen() {
        super.onSessionOpen();
        this.f3899b.f3895a.mo1921a();
    }

    /* renamed from: a */
    public void mo825a() {
        this.f3900c = new C0640n(this, this.f3898a).m2923f(this.f3899b.f3896b);
    }

    /* renamed from: b */
    public void mo827b() {
        if (!this.f3898a.m3365a(this.f3899b.f3897c.f3622f)) {
            this.f3899b.f3895a.mo1922a("");
        } else if (this.f3900c.b != 0) {
            this.f3899b.f3895a.mo1922a(this.f3900c.c);
        } else {
            this.f3899b.f3897c.m5119b();
            this.f3899b.f3895a.mo1923b();
        }
    }

    /* renamed from: a */
    public void mo826a(String str) {
        if (this.f3898a.m3365a(this.f3899b.f3897c.f3622f)) {
            this.f3899b.f3895a.mo1922a(str);
        } else {
            this.f3899b.f3895a.mo1922a("");
        }
    }

    /* renamed from: c */
    public boolean mo828c() {
        return this.f3900c.b == 1001 || this.f3900c.b == ICallback.LOGIN_OAUTH_AIDL || this.f3900c.b == ICallback.CLEAR_ACCOUNT_AIDL;
    }
}
