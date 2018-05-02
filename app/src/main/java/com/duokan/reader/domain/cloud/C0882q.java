package com.duokan.reader.domain.cloud;

import com.duokan.p023b.C0247i;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0647u;
import com.duokan.reader.common.webservices.duokan.C0651y;
import com.duokan.reader.common.webservices.duokan.C0652z;
import com.duokan.reader.common.webservices.duokan.DkStoreBookDetailInfo;
import com.duokan.reader.domain.account.C0672a;

/* renamed from: com.duokan.reader.domain.cloud.q */
class C0882q extends WebSession {
    /* renamed from: a */
    final /* synthetic */ C0672a f4174a;
    /* renamed from: b */
    final /* synthetic */ C0855p f4175b;
    /* renamed from: c */
    private C0621a<DkStoreBookDetailInfo> f4176c = null;
    /* renamed from: d */
    private C0621a<C0651y> f4177d = null;

    C0882q(C0855p c0855p, C0657i c0657i, C0672a c0672a) {
        this.f4175b = c0855p;
        this.f4174a = c0672a;
        super(c0657i);
    }

    protected void onSessionTry() {
        C0647u c0647u = new C0647u(this, this.f4174a);
        C0652z c0652z = new C0652z((WebSession) this, this.f4174a);
        this.f4176c = c0647u.m3033a(this.f4175b.f4086a, false);
        this.f4177d = c0652z.m3078g(this.f4175b.f4086a, ((DkStoreBookDetailInfo) this.f4176c.f2058a).mRevision);
    }

    protected void onSessionSucceeded() {
        if (this.f4176c.b == 0 && this.f4177d.b == 0) {
            this.f4175b.f4087b.mo1047a(this.f4175b.f4086a, new DkCloudBookManifest(this.f4175b.f4086a, ((DkStoreBookDetailInfo) this.f4176c.f2058a).mRevision, ((DkStoreBookDetailInfo) this.f4176c.f2058a).mEpubUri, ((DkStoreBookDetailInfo) this.f4176c.f2058a).mEpubMd5, ((DkStoreBookDetailInfo) this.f4176c.f2058a).mOpfUri, "", (C0651y) this.f4177d.f2058a));
            return;
        }
        this.f4175b.f4087b.mo1048a(this.f4175b.f4086a, this.f4175b.f4088c.f3595c.getString(C0247i.general__shared__network_error));
    }

    protected void onSessionFailed() {
        this.f4175b.f4087b.mo1048a(this.f4175b.f4086a, this.f4175b.f4088c.f3595c.getString(C0247i.general__shared__network_error));
    }
}
