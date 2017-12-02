package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.DkSyncService;
import com.duokan.reader.common.webservices.duokan.b;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.i;
import com.mipay.sdk.Mipay;

import org.w3c.dom.Node;

class v extends b {
    final /* synthetic */ a a;
    final /* synthetic */ DkCloudReadingInfo b;
    final /* synthetic */ String c;
    final /* synthetic */ DkCloudReadingInfo d;
    final /* synthetic */ DkCloudReadingInfo e;
    final /* synthetic */ DkCloudAnnotation[] f;
    final /* synthetic */ String g;
    final /* synthetic */ as h;
    final /* synthetic */ DkCloudStorage i;
    private com.duokan.reader.common.webservices.b j = null;

    v(DkCloudStorage dkCloudStorage, a aVar, DkCloudReadingInfo dkCloudReadingInfo, String str, DkCloudReadingInfo dkCloudReadingInfo2, DkCloudReadingInfo dkCloudReadingInfo3, DkCloudAnnotation[] dkCloudAnnotationArr, String str2, as asVar) {
        this.i = dkCloudStorage;
        this.a = aVar;
        this.b = dkCloudReadingInfo;
        this.c = str;
        this.d = dkCloudReadingInfo2;
        this.e = dkCloudReadingInfo3;
        this.f = dkCloudAnnotationArr;
        this.g = str2;
        this.h = asVar;
    }

    protected void onSessionTry() {
        DkSyncService dkSyncService = new DkSyncService((WebSession) this, this.a);
        Node b = com.duokan.reader.common.e.a.b("BookInfo");
        this.b.fillXmlNodeWithAnnotations(b);
        this.j = dkSyncService.a(this.b.getCloudId(), this.b.getBookName(), this.b.getIsDuokanBook(), b, this.b.getCloudVersion());
    }

    protected void onSessionSucceeded() {
        if (this.j.b == 3) {
            i.f().a(this.c, new w(this));
        } else if (this.j.b == 7) {
            try {
                DkCloudReadingInfo dkCloudReadingInfo = new DkCloudReadingInfo(this.e.getIsDuokanBook(), this.e.getBookName(), (Node) this.j.a, com.duokan.reader.common.e.a.a(com.duokan.reader.common.e.a.f((Node) this.j.a, Mipay.KEY_RESULT), "latestversion"));
                if (dkCloudReadingInfo.getBookRevision() == null || this.e.getBookRevision() == null || dkCloudReadingInfo.getBookRevision().compareTo(this.e.getBookRevision()) <= 0) {
                    this.i.a(this.d, this.a, dkCloudReadingInfo, this.f, this.g, this.h);
                    return;
                }
                this.h.b(this.e, "", this.g);
            } catch (Exception e) {
                e.printStackTrace();
                this.h.b(this.e, "", this.g);
            }
        } else if (this.j.b == 0) {
            long a = com.duokan.reader.common.e.a.a(com.duokan.reader.common.e.a.f((Node) this.j.a, Mipay.KEY_RESULT), "latestversion");
            this.d.setAnnotations(this.b.getAnnotations());
            this.d.setCloudVersion(a);
            this.h.b(this.e, this.d, this.g);
        } else {
            this.h.b(this.e, this.j.c, this.g);
        }
    }

    protected void onSessionFailed() {
        this.h.b(this.e, this.i.c.getString(com.duokan.b.i.general__shared__network_error), this.g);
    }
}
