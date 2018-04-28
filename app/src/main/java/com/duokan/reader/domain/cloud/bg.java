package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0652z;
import com.duokan.reader.domain.account.ReloginSession;
import com.duokan.reader.domain.account.al;
import com.wali.live.sdk.manager.IMiLiveSdk.ICallback;
import java.util.LinkedList;

class bg extends ReloginSession {
    /* renamed from: a */
    final /* synthetic */ al f3748a;
    /* renamed from: b */
    final /* synthetic */ bf f3749b;
    /* renamed from: c */
    private C0621a<Void> f3750c = null;
    /* renamed from: d */
    private LinkedList<DkCloudPurchasedBook> f3751d = new LinkedList();

    bg(bf bfVar, String str, C0657i c0657i, al alVar) {
        this.f3749b = bfVar;
        this.f3748a = alVar;
        super(str, c0657i);
    }

    /* renamed from: a */
    public void mo825a() {
        this.f3750c = new C0652z((WebSession) this, this.f3748a).m3062a(true, this.f3749b.f3747a.f3744a);
        if (this.f3750c.b == 0) {
            cj cjVar = new cj(this.f3748a);
            cjVar.m5406a();
            for (String queryItem : this.f3749b.f3747a.f3744a) {
                DkCloudPurchasedBook dkCloudPurchasedBook = (DkCloudPurchasedBook) cjVar.queryItem(queryItem);
                if (dkCloudPurchasedBook != null) {
                    dkCloudPurchasedBook.setHidden(true);
                    cjVar.updateItem(dkCloudPurchasedBook);
                    this.f3751d.add(dkCloudPurchasedBook);
                }
            }
        }
    }

    /* renamed from: b */
    public void mo827b() {
        if (!this.f3748a.m3365a(DkUserPurchasedBooksManager.m5051h())) {
            this.f3749b.f3747a.f3745b.mo729a(-1, "");
        } else if (this.f3750c.b != 0) {
            this.f3749b.f3747a.f3745b.mo729a(this.f3750c.b, this.f3750c.c);
        } else {
            if (!this.f3751d.isEmpty()) {
                this.f3749b.f3747a.f3746c.f3608h.m5398a(this.f3751d);
                this.f3749b.f3747a.f3746c.m5048f();
                this.f3749b.f3747a.f3746c.m5038a(this.f3749b.f3747a.f3744a);
            }
            this.f3749b.f3747a.f3745b.mo730a(null);
        }
    }

    /* renamed from: a */
    public void mo826a(String str) {
        if (this.f3748a.m3365a(DkUserPurchasedBooksManager.m5051h())) {
            this.f3749b.f3747a.f3745b.mo729a(-1, str);
        } else {
            this.f3749b.f3747a.f3745b.mo729a(-1, "");
        }
    }

    /* renamed from: c */
    public boolean mo828c() {
        return this.f3750c.b == 1001 || this.f3750c.b == ICallback.LOGIN_OAUTH_AIDL || this.f3750c.b == ICallback.CLEAR_ACCOUNT_AIDL;
    }
}
