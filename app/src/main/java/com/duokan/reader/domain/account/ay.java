package com.duokan.reader.domain.account;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.domain.social.p048b.C1134a;
import com.wali.live.sdk.manager.IMiLiveSdk.ICallback;

class ay extends ReloginSession {
    /* renamed from: a */
    final /* synthetic */ String f2393a;
    /* renamed from: b */
    final /* synthetic */ ba f2394b;
    /* renamed from: c */
    final /* synthetic */ MiAccount f2395c;
    /* renamed from: d */
    private C0621a<Void> f2396d = null;

    ay(MiAccount miAccount, String str, C0657i c0657i, String str2, ba baVar) {
        this.f2395c = miAccount;
        this.f2393a = str2;
        this.f2394b = baVar;
        super(str, c0657i);
    }

    /* renamed from: a */
    public void mo825a() {
        this.f2396d = new C1134a(this, this.f2395c).m8456e(this.f2393a);
    }

    /* renamed from: b */
    public void mo827b() {
        if (this.f2396d.b == 0) {
            this.f2395c.f2254g.f2405e.f5459b.f5468i = this.f2393a;
            this.f2395c.m3155l();
            this.f2395c.a.mo881c(this.f2395c);
            this.f2394b.mo1588a();
            return;
        }
        this.f2394b.mo1589a(this.f2396d.b, this.f2396d.c);
    }

    /* renamed from: a */
    public void mo826a(String str) {
        this.f2394b.mo1589a(-1, str);
    }

    /* renamed from: c */
    public boolean mo828c() {
        return this.f2396d.b == 1001 || this.f2396d.b == ICallback.LOGIN_OAUTH_AIDL || this.f2396d.b == ICallback.CLEAR_ACCOUNT_AIDL;
    }
}
