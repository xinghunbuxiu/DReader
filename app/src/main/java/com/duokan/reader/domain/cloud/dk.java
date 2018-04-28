package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0652z;
import com.duokan.reader.domain.account.ReloginSession;
import com.duokan.reader.domain.account.al;
import com.wali.live.sdk.manager.IMiLiveSdk.ICallback;
import java.util.LinkedList;

class dk extends ReloginSession {
    /* renamed from: a */
    final /* synthetic */ al f3881a;
    /* renamed from: b */
    final /* synthetic */ dj f3882b;
    /* renamed from: c */
    private C0621a<Void> f3883c = null;
    /* renamed from: d */
    private LinkedList<DkCloudPurchasedFiction> f3884d = new LinkedList();

    dk(dj djVar, String str, C0657i c0657i, al alVar) {
        this.f3882b = djVar;
        this.f3881a = alVar;
        super(str, c0657i);
    }

    /* renamed from: a */
    public void mo825a() {
        this.f3883c = new C0652z((WebSession) this, this.f3881a).m3066b(true, this.f3882b.f3880a.f3877a);
        if (this.f3883c.b == 0) {
            dt dtVar = new dt(this.f3881a);
            dtVar.m5468a();
            for (String queryItem : this.f3882b.f3880a.f3877a) {
                DkCloudPurchasedFiction dkCloudPurchasedFiction = (DkCloudPurchasedFiction) dtVar.queryItem(queryItem);
                if (dkCloudPurchasedFiction != null) {
                    dkCloudPurchasedFiction.setHidden(true);
                    dtVar.updateItem(dkCloudPurchasedFiction);
                    this.f3884d.add(dkCloudPurchasedFiction);
                }
            }
        }
    }

    /* renamed from: b */
    public void mo827b() {
        if (!this.f3881a.m3365a(DkUserPurchasedFictionsManager.m5092g())) {
            this.f3882b.f3880a.f3878b.mo729a(-1, "");
        } else if (this.f3883c.b != 0) {
            this.f3882b.f3880a.f3878b.mo729a(this.f3883c.b, this.f3883c.c);
        } else {
            if (!this.f3884d.isEmpty()) {
                this.f3882b.f3880a.f3879c.f3616h.m5461a(this.f3884d);
                this.f3882b.f3880a.f3879c.m5091f();
                this.f3882b.f3880a.f3879c.m5081a(this.f3882b.f3880a.f3877a);
            }
            this.f3882b.f3880a.f3878b.mo730a(null);
        }
    }

    /* renamed from: a */
    public void mo826a(String str) {
        if (this.f3881a.m3365a(DkUserPurchasedFictionsManager.m5092g())) {
            this.f3882b.f3880a.f3878b.mo729a(-1, str);
        } else {
            this.f3882b.f3880a.f3878b.mo729a(-1, "");
        }
    }

    /* renamed from: c */
    public boolean mo828c() {
        return this.f3883c.b == 1001 || this.f3883c.b == ICallback.LOGIN_OAUTH_AIDL || this.f3883c.b == ICallback.CLEAR_ACCOUNT_AIDL;
    }
}
