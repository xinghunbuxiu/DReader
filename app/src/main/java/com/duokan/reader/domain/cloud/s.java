package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.DkSyncService;
import com.duokan.reader.common.webservices.duokan.b;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.cloud.DkCloudStorage.ConflictStrategy;
import com.mipay.sdk.Mipay;

import org.w3c.dom.Node;

class s extends b {
    final /* synthetic */ a a;
    final /* synthetic */ DkCloudReadingInfo b;
    final /* synthetic */ String c;
    final /* synthetic */ DkCloudReadingInfo d;
    final /* synthetic */ ConflictStrategy e;
    final /* synthetic */ String f;
    final /* synthetic */ as g;
    final /* synthetic */ DkCloudStorage h;
    private com.duokan.reader.common.webservices.b i = null;

    s(DkCloudStorage dkCloudStorage, a aVar, DkCloudReadingInfo dkCloudReadingInfo, String str, DkCloudReadingInfo dkCloudReadingInfo2, ConflictStrategy conflictStrategy, String str2, as asVar) {
        this.h = dkCloudStorage;
        this.a = aVar;
        this.b = dkCloudReadingInfo;
        this.c = str;
        this.d = dkCloudReadingInfo2;
        this.e = conflictStrategy;
        this.f = str2;
        this.g = asVar;
    }

    protected void onSessionTry() {
        DkSyncService dkSyncService = new DkSyncService((WebSession) this, this.a);
        Node b = com.duokan.reader.common.e.a.b("BookInfo");
        this.b.fillXmlNodeWithAnnotations(b);
        this.i = dkSyncService.a(this.b.getCloudId(), this.b.getBookName(), this.b.getIsDuokanBook(), b, this.b.getCloudVersion());
    }

    protected void onSessionSucceeded() {
        if (this.i.b == 3) {
            i.f().a(this.c, new t(this));
        } else if (this.i.b == 7) {
            this.g.b(this.b, this.i.c, this.f);
        } else if (this.i.b == 0) {
            long a = com.duokan.reader.common.e.a.a(com.duokan.reader.common.e.a.f((Node) this.i.a, Mipay.KEY_RESULT), "latestversion");
            this.d.setAnnotations(this.b.getAnnotations());
            this.d.setCloudVersion(a);
            this.h.a(this.d);
            this.g.b(this.b, this.d, this.f);
        } else {
            this.g.b(this.b, this.i.c, this.f);
        }
    }

    protected void onSessionFailed() {
        this.g.b(this.b, this.h.c.getString(com.duokan.b.i.general__shared__network_error), this.f);
    }
}
