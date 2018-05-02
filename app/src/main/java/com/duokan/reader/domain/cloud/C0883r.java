package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.p039e.C0606a;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.DkSyncService;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.ReloginSession;
import com.mipay.sdk.Mipay;
import org.w3c.dom.Node;

/* renamed from: com.duokan.reader.domain.cloud.r */
class C0883r extends ReloginSession {
    /* renamed from: a */
    final /* synthetic */ C0672a f4178a;
    /* renamed from: b */
    final /* synthetic */ DkCloudReadingInfo f4179b;
    /* renamed from: c */
    final /* synthetic */ al f4180c;
    /* renamed from: d */
    final /* synthetic */ String f4181d;
    /* renamed from: e */
    final /* synthetic */ DkCloudReadingInfo f4182e;
    /* renamed from: f */
    final /* synthetic */ DkCloudStorage f4183f;
    /* renamed from: g */
    private C0621a<Node> f4184g = null;

    C0883r(DkCloudStorage dkCloudStorage, String str, C0657i c0657i, C0672a c0672a, DkCloudReadingInfo dkCloudReadingInfo, al alVar, String str2, DkCloudReadingInfo dkCloudReadingInfo2) {
        this.f4183f = dkCloudStorage;
        this.f4178a = c0672a;
        this.f4179b = dkCloudReadingInfo;
        this.f4180c = alVar;
        this.f4181d = str2;
        this.f4182e = dkCloudReadingInfo2;
        super(str, c0657i);
    }

    /* renamed from: a */
    public void mo825a() {
        DkSyncService dkSyncService = new DkSyncService((WebSession) this, this.f4178a);
        Node b = C0606a.m2778b("BookInfo");
        this.f4179b.fillXmlNodeWithAnnotations(b);
        this.f4184g = dkSyncService.m2824a(this.f4179b.getCloudId(), this.f4179b.getBookName(), this.f4179b.getIsDuokanBook(), b, this.f4179b.getCloudVersion());
    }

    /* renamed from: b */
    public void mo827b() {
        if (this.f4184g.b == 7) {
            this.f4180c.mo1115b(this.f4179b, this.f4184g.c, this.f4181d);
        } else if (this.f4184g.b == 0) {
            long a = C0606a.m2773a(C0606a.m2783f((Node) this.f4184g.f2058a, Mipay.KEY_RESULT), "latestversion");
            this.f4182e.setAnnotations(this.f4179b.getAnnotations());
            this.f4182e.setCloudVersion(a);
            this.f4183f.m4997a(this.f4182e);
            this.f4180c.mo1114b(this.f4179b, this.f4182e, this.f4181d);
        } else {
            this.f4180c.mo1115b(this.f4179b, this.f4184g.c, this.f4181d);
        }
    }

    /* renamed from: a */
    public void mo826a(String str) {
        this.f4180c.mo1115b(this.f4179b, str, this.f4181d);
    }

    /* renamed from: c */
    public boolean mo828c() {
        return this.f4184g.b == 3;
    }
}
