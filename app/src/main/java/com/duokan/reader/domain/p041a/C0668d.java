package com.duokan.reader.domain.p041a;

import android.text.TextUtils;
import com.duokan.p023b.C0247i;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.duokan.C0623g;
import com.duokan.reader.common.webservices.duokan.C0635i;
import com.duokan.reader.common.webservices.duokan.C0640n;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.ReloginSession;
import com.wali.live.sdk.manager.IMiLiveSdk.ICallback;

/* renamed from: com.duokan.reader.domain.a.d */
class C0668d extends ReloginSession {
    /* renamed from: a */
    final /* synthetic */ C0672a f2237a;
    /* renamed from: b */
    final /* synthetic */ C0667c f2238b;
    /* renamed from: c */
    private C0621a<C0623g> f2239c = null;
    /* renamed from: d */
    private C0621a<String> f2240d = null;

    C0668d(C0667c c0667c, String str, C0657i c0657i, C0672a c0672a) {
        this.f2238b = c0667c;
        this.f2237a = c0672a;
        super(str, c0657i);
    }

    /* renamed from: a */
    public void mo825a() {
        this.f2240d = new C0640n(this, null).m2924g(this.f2238b.f2228a);
        this.f2239c = new C0635i(this, this.f2237a).m2872a((String) this.f2240d.f2058a, this.f2238b.f2229b, this.f2238b.f2230c, this.f2238b.f2231d);
    }

    /* renamed from: b */
    public void mo827b() {
        if (this.f2239c.b == 0 || this.f2239c.b == 410013) {
            this.f2238b.f2232e.mo2309a((C0623g) this.f2239c.f2058a);
        } else if (this.f2239c.b == 14) {
            this.f2238b.f2232e.mo2310a(this.f2238b.f2233f.f2220c.getString(C0247i.general__shared__local_time_error));
        } else if (TextUtils.isEmpty(this.f2239c.c)) {
            this.f2238b.f2232e.mo2310a(this.f2238b.f2233f.f2220c.getString(C0247i.general__shared__network_error));
        } else {
            this.f2238b.f2232e.mo2310a(this.f2239c.c);
        }
    }

    /* renamed from: a */
    public void mo826a(String str) {
        this.f2238b.f2232e.mo2310a(str);
    }

    /* renamed from: c */
    public boolean mo828c() {
        return this.f2239c.b == 1001 || this.f2239c.b == ICallback.LOGIN_OAUTH_AIDL || this.f2239c.b == ICallback.CLEAR_ACCOUNT_AIDL;
    }
}
