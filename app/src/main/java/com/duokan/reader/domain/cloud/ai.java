package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.DkSyncService;
import com.duokan.reader.common.webservices.duokan.b;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.i;

import org.w3c.dom.Node;

class ai extends b {
    final /* synthetic */ a a;
    final /* synthetic */ DkCloudReadingInfo b;
    final /* synthetic */ String c;
    final /* synthetic */ DkCloudReadingInfo d;
    final /* synthetic */ String e;
    final /* synthetic */ ar f;
    final /* synthetic */ DkCloudStorage g;
    private com.duokan.reader.common.webservices.b h = null;

    ai(DkCloudStorage dkCloudStorage, a aVar, DkCloudReadingInfo dkCloudReadingInfo, String str, DkCloudReadingInfo dkCloudReadingInfo2, String str2, ar arVar) {
        this.g = dkCloudStorage;
        this.a = aVar;
        this.b = dkCloudReadingInfo;
        this.c = str;
        this.d = dkCloudReadingInfo2;
        this.e = str2;
        this.f = arVar;
    }

    protected void onSessionTry() {
        this.h = new DkSyncService((WebSession) this, this.a).a(this.b.getCloudId(), this.b.getIsDuokanBook());
    }

    protected void onSessionSucceeded() {
        if (this.h.b == 3) {
            i.f().a(this.c, new aj(this));
        } else if (this.h.b == 0) {
            try {
                DkCloudItem dkCloudReadingInfo = new DkCloudReadingInfo(this.b.getIsDuokanBook(), this.b.getBookName(), (Node) this.h.a, 0);
                if (dkCloudReadingInfo.getReadingProgress() == null) {
                    this.f.a(this.b, "", this.e);
                    return;
                }
                this.d.setReadingProgress(((DkCloudReadingInfo) this.b.merge(dkCloudReadingInfo)).getReadingProgress());
                this.f.a(this.b, this.d, this.e);
            } catch (Exception e) {
                e.printStackTrace();
                this.f.a(this.b, "", this.e);
            }
        } else {
            this.f.a(this.b, this.h.c, this.e);
        }
    }

    protected void onSessionFailed() {
        this.f.a(this.b, this.g.c.getString(com.duokan.b.i.general__shared__network_error), this.e);
    }
}
