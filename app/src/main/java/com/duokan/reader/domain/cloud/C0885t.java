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

/* renamed from: com.duokan.reader.domain.cloud.t */
class C0885t extends ReloginSession {
    /* renamed from: a */
    final /* synthetic */ C0672a f4186a;
    /* renamed from: b */
    final /* synthetic */ DkCloudReadingInfo f4187b;
    /* renamed from: c */
    final /* synthetic */ DkCloudReadingInfo f4188c;
    /* renamed from: d */
    final /* synthetic */ al f4189d;
    /* renamed from: e */
    final /* synthetic */ String f4190e;
    /* renamed from: f */
    final /* synthetic */ DkCloudReadingInfo f4191f;
    /* renamed from: g */
    final /* synthetic */ DkCloudAnnotation[] f4192g;
    /* renamed from: h */
    final /* synthetic */ DkCloudStorage f4193h;
    /* renamed from: i */
    private C0621a<Node> f4194i = null;

    C0885t(DkCloudStorage dkCloudStorage, String str, C0657i c0657i, C0672a c0672a, DkCloudReadingInfo dkCloudReadingInfo, DkCloudReadingInfo dkCloudReadingInfo2, al alVar, String str2, DkCloudReadingInfo dkCloudReadingInfo3, DkCloudAnnotation[] dkCloudAnnotationArr) {
        this.f4193h = dkCloudStorage;
        this.f4186a = c0672a;
        this.f4187b = dkCloudReadingInfo;
        this.f4188c = dkCloudReadingInfo2;
        this.f4189d = alVar;
        this.f4190e = str2;
        this.f4191f = dkCloudReadingInfo3;
        this.f4192g = dkCloudAnnotationArr;
        super(str, c0657i);
    }

    /* renamed from: a */
    public void mo825a() {
        DkSyncService dkSyncService = new DkSyncService((WebSession) this, this.f4186a);
        Node b = C0606a.m2778b("BookInfo");
        this.f4187b.fillXmlNodeWithAnnotations(b);
        this.f4194i = dkSyncService.m2824a(this.f4187b.getCloudId(), this.f4187b.getBookName(), this.f4187b.getIsDuokanBook(), b, this.f4187b.getCloudVersion());
    }

    /* renamed from: b */
    public void mo827b() {
        if (this.f4194i.b == 7) {
            try {
                DkCloudReadingInfo dkCloudReadingInfo = new DkCloudReadingInfo(this.f4188c.getIsDuokanBook(), this.f4188c.getBookName(), (Node) this.f4194i.f2058a, C0606a.m2773a(C0606a.m2783f((Node) this.f4194i.f2058a, Mipay.KEY_RESULT), "latestversion"));
                if (dkCloudReadingInfo.getBookRevision() == null || this.f4188c.getBookRevision() == null || dkCloudReadingInfo.getBookRevision().compareTo(this.f4188c.getBookRevision()) <= 0) {
                    this.f4193h.m5001a(this.f4191f, this.f4186a, dkCloudReadingInfo, this.f4192g, this.f4190e, this.f4189d);
                    return;
                }
                this.f4189d.mo1115b(this.f4188c, "", this.f4190e);
            } catch (Exception e) {
                e.printStackTrace();
                this.f4189d.mo1115b(this.f4188c, "", this.f4190e);
            }
        } else if (this.f4194i.b == 0) {
            long a = C0606a.m2773a(C0606a.m2783f((Node) this.f4194i.f2058a, Mipay.KEY_RESULT), "latestversion");
            this.f4191f.setAnnotations(this.f4187b.getAnnotations());
            this.f4191f.setCloudVersion(a);
            this.f4189d.mo1114b(this.f4188c, this.f4191f, this.f4190e);
        } else {
            this.f4189d.mo1115b(this.f4188c, this.f4194i.c, this.f4190e);
        }
    }

    /* renamed from: a */
    public void mo826a(String str) {
        this.f4189d.mo1115b(this.f4188c, str, this.f4190e);
    }

    /* renamed from: c */
    public boolean mo828c() {
        return this.f4194i.b == 3;
    }
}
