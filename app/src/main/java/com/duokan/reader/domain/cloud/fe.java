package com.duokan.reader.domain.cloud;

import com.duokan.p023b.C0247i;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0652z;
import com.duokan.reader.common.webservices.duokan.DkStoreOrderInfo;
import com.duokan.reader.domain.account.ReloginSession;
import com.duokan.reader.domain.store.C1187m;
import com.wali.live.sdk.manager.IMiLiveSdk.ICallback;

class fe extends ReloginSession {
    /* renamed from: a */
    final /* synthetic */ String f3989a;
    /* renamed from: b */
    final /* synthetic */ fd f3990b;
    /* renamed from: c */
    private C0621a<DkStoreOrderInfo> f3991c = null;

    fe(fd fdVar, String str, C0657i c0657i, String str2) {
        this.f3990b = fdVar;
        this.f3989a = str2;
        super(str, c0657i);
    }

    /* renamed from: a */
    public void mo825a() {
        this.f3991c = new C0652z((WebSession) this, this.f3990b.f3986b).m3069c(this.f3989a, this.f3990b.f3987c.mBookUuid);
    }

    /* renamed from: b */
    public void mo827b() {
        if (this.f3991c.b != 0) {
            this.f3990b.f3988d.f3983c.mo1161a(String.format(this.f3990b.f3988d.f3984d.f3957c.getString(C0247i.bookcity_store__shared__fail_to_create_order_as_error), new Object[]{Integer.valueOf(this.f3991c.b)}));
            return;
        }
        this.f3990b.f3988d.f3984d.m5524a(new C1187m((DkStoreOrderInfo) this.f3991c.f2058a, this.f3990b.f3987c), this.f3989a, new ff(this));
    }

    /* renamed from: a */
    public void mo826a(String str) {
        this.f3990b.f3988d.f3983c.mo1161a(this.f3990b.f3988d.f3984d.f3957c.getString(C0247i.bookcity_store__shared__fail_to_create_order_as_network_error));
    }

    /* renamed from: c */
    public boolean mo828c() {
        return this.f3991c.b == 1001 || this.f3991c.b == ICallback.LOGIN_OAUTH_AIDL || this.f3991c.b == ICallback.CLEAR_ACCOUNT_AIDL;
    }
}
