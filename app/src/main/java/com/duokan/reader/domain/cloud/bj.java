package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0652z;
import com.duokan.reader.domain.account.ReloginSession;
import com.duokan.reader.domain.account.al;
import com.wali.live.sdk.manager.IMiLiveSdk.ICallback;

class bj extends ReloginSession {
    /* renamed from: a */
    final /* synthetic */ al f3756a;
    /* renamed from: b */
    final /* synthetic */ bi f3757b;
    /* renamed from: c */
    private C0621a<Void> f3758c = null;
    /* renamed from: d */
    private DkCloudPurchasedBook f3759d = null;

    bj(bi biVar, String str, C0657i c0657i, al alVar) {
        this.f3757b = biVar;
        this.f3756a = alVar;
        super(str, c0657i);
    }

    /* renamed from: a */
    public void mo825a() {
        this.f3758c = new C0652z((WebSession) this, this.f3756a).m3062a(false, this.f3757b.f3755a.f3752a);
        if (this.f3758c.b == 0) {
            cj cjVar = new cj(this.f3756a);
            cjVar.m5406a();
            DkCloudPurchasedBook dkCloudPurchasedBook = (DkCloudPurchasedBook) cjVar.queryItem(this.f3757b.f3755a.f3752a);
            if (dkCloudPurchasedBook != null) {
                dkCloudPurchasedBook.setHidden(false);
                cjVar.updateItem(dkCloudPurchasedBook);
                this.f3759d = dkCloudPurchasedBook;
            }
        }
    }

    /* renamed from: b */
    public void mo827b() {
        if (!this.f3756a.m3365a(DkUserPurchasedBooksManager.m5051h())) {
            this.f3757b.f3755a.f3753b.mo729a(-1, "");
        } else if (this.f3758c.b != 0) {
            this.f3757b.f3755a.f3753b.mo729a(this.f3758c.b, this.f3758c.c);
        } else {
            if (this.f3759d != null) {
                this.f3757b.f3755a.f3754c.f3608h.m5397a(this.f3759d);
                this.f3757b.f3755a.f3754c.m5048f();
            }
            this.f3757b.f3755a.f3753b.mo730a(null);
        }
    }

    /* renamed from: a */
    public void mo826a(String str) {
        if (this.f3756a.m3365a(DkUserPurchasedBooksManager.m5051h())) {
            this.f3757b.f3755a.f3753b.mo729a(-1, str);
        } else {
            this.f3757b.f3755a.f3753b.mo729a(-1, "");
        }
    }

    /* renamed from: c */
    public boolean mo828c() {
        return this.f3758c.b == 1001 || this.f3758c.b == ICallback.LOGIN_OAUTH_AIDL || this.f3758c.b == ICallback.CLEAR_ACCOUNT_AIDL;
    }
}
