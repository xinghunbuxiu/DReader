package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0652z;
import com.duokan.reader.domain.account.ReloginSession;
import com.duokan.reader.domain.account.al;
import com.wali.live.sdk.manager.IMiLiveSdk.ICallback;

class cu extends ReloginSession {
    /* renamed from: a */
    final /* synthetic */ al f3837a;
    /* renamed from: b */
    final /* synthetic */ ct f3838b;
    /* renamed from: c */
    private C0621a<Void> f3839c = null;
    /* renamed from: d */
    private DkCloudPurchasedFiction f3840d = null;

    cu(ct ctVar, String str, C0657i c0657i, al alVar) {
        this.f3838b = ctVar;
        this.f3837a = alVar;
        super(str, c0657i);
    }

    /* renamed from: a */
    public void mo825a() {
        this.f3839c = new C0652z((WebSession) this, this.f3837a).m3066b(false, this.f3838b.f3836a.f3833a);
        if (this.f3839c.b == 0) {
            dt dtVar = new dt(this.f3837a);
            dtVar.m5468a();
            DkCloudPurchasedFiction dkCloudPurchasedFiction = (DkCloudPurchasedFiction) dtVar.queryItem(this.f3838b.f3836a.f3833a);
            if (dkCloudPurchasedFiction != null) {
                dkCloudPurchasedFiction.setHidden(false);
                dtVar.updateItem(dkCloudPurchasedFiction);
                this.f3840d = dkCloudPurchasedFiction;
            }
        }
    }

    /* renamed from: b */
    public void mo827b() {
        if (!this.f3837a.m3365a(DkUserPurchasedFictionsManager.m5092g())) {
            this.f3838b.f3836a.f3834b.mo729a(-1, "");
        } else if (this.f3839c.b != 0) {
            this.f3838b.f3836a.f3834b.mo729a(this.f3839c.b, this.f3839c.c);
        } else {
            if (this.f3840d != null) {
                this.f3838b.f3836a.f3835c.f3616h.m5460a(this.f3840d);
                this.f3838b.f3836a.f3835c.m5091f();
            }
            this.f3838b.f3836a.f3834b.mo730a(null);
        }
    }

    /* renamed from: a */
    public void mo826a(String str) {
        if (this.f3837a.m3365a(DkUserPurchasedFictionsManager.m5092g())) {
            this.f3838b.f3836a.f3834b.mo729a(-1, str);
        } else {
            this.f3838b.f3836a.f3834b.mo729a(-1, "");
        }
    }

    /* renamed from: c */
    public boolean mo828c() {
        return this.f3839c.b == 1001 || this.f3839c.b == ICallback.LOGIN_OAUTH_AIDL || this.f3839c.b == ICallback.CLEAR_ACCOUNT_AIDL;
    }
}
