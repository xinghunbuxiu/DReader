package com.duokan.reader.domain.cloud;

import com.duokan.p023b.C0247i;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.DkSyncService;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.ReloginSession;
import org.w3c.dom.Node;

class ae extends ReloginSession {
    /* renamed from: a */
    final /* synthetic */ C0672a f3663a;
    /* renamed from: b */
    final /* synthetic */ DkCloudReadingInfo f3664b;
    /* renamed from: c */
    final /* synthetic */ ak f3665c;
    /* renamed from: d */
    final /* synthetic */ String f3666d;
    /* renamed from: e */
    final /* synthetic */ DkCloudReadingInfo f3667e;
    /* renamed from: f */
    final /* synthetic */ DkCloudStorage f3668f;
    /* renamed from: g */
    private C0621a<Node> f3669g = null;

    ae(DkCloudStorage dkCloudStorage, String str, C0657i c0657i, C0672a c0672a, DkCloudReadingInfo dkCloudReadingInfo, ak akVar, String str2, DkCloudReadingInfo dkCloudReadingInfo2) {
        this.f3668f = dkCloudStorage;
        this.f3663a = c0672a;
        this.f3664b = dkCloudReadingInfo;
        this.f3665c = akVar;
        this.f3666d = str2;
        this.f3667e = dkCloudReadingInfo2;
        super(str, c0657i);
    }

    /* renamed from: a */
    public void mo825a() {
        this.f3669g = new DkSyncService((WebSession) this, this.f3663a).m2825a(this.f3664b.getCloudId(), this.f3664b.getIsDuokanBook());
    }

    /* renamed from: b */
    public void mo827b() {
        if (this.f3669g.b == 0) {
            try {
                DkCloudItem dkCloudReadingInfo = new DkCloudReadingInfo(this.f3664b.getIsDuokanBook(), this.f3664b.getBookName(), (Node) this.f3669g.f2058a, 0);
                if (dkCloudReadingInfo.getReadingProgress() == null) {
                    this.f3665c.mo1085a(this.f3664b, "", this.f3666d);
                    return;
                }
                this.f3667e.setReadingProgress(((DkCloudReadingInfo) this.f3664b.merge(dkCloudReadingInfo)).getReadingProgress());
                this.f3665c.mo1084a(this.f3664b, this.f3667e, this.f3666d);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                this.f3665c.mo1085a(this.f3664b, "", this.f3666d);
                return;
            }
        }
        this.f3665c.mo1085a(this.f3664b, this.f3669g.c, this.f3666d);
    }

    /* renamed from: a */
    public void mo826a(String str) {
        this.f3665c.mo1085a(this.f3664b, this.f3668f.f3595c.getString(C0247i.general__shared__network_error), this.f3666d);
    }

    /* renamed from: c */
    public boolean mo828c() {
        return this.f3669g.b == 3;
    }
}
