package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.DkSyncService;
import com.duokan.reader.common.webservices.duokan.b;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.bookshelf.ju;

import org.json.JSONObject;

class ak extends b {
    final /* synthetic */ a a;
    final /* synthetic */ DkCloudReadingInfo b;
    final /* synthetic */ int c;
    final /* synthetic */ ju d;
    final /* synthetic */ String e;
    final /* synthetic */ DkCloudReadingInfo f;
    final /* synthetic */ String g;
    final /* synthetic */ as h;
    final /* synthetic */ DkCloudStorage i;
    private com.duokan.reader.common.webservices.b j = null;

    ak(DkCloudStorage dkCloudStorage, a aVar, DkCloudReadingInfo dkCloudReadingInfo, int i, ju juVar, String str, DkCloudReadingInfo dkCloudReadingInfo2, String str2, as asVar) {
        this.i = dkCloudStorage;
        this.a = aVar;
        this.b = dkCloudReadingInfo;
        this.c = i;
        this.d = juVar;
        this.e = str;
        this.f = dkCloudReadingInfo2;
        this.g = str2;
        this.h = asVar;
    }

    protected void onSessionTry() {
        DkSyncService dkSyncService = new DkSyncService((WebSession) this, this.a);
        JSONObject jSONObject = new JSONObject();
        this.b.fillJsonObjectWithReadingProgress(jSONObject);
        this.j = dkSyncService.a(this.b.getCloudId(), this.b.getBookName(), this.b.getIsDuokanBook(), this.c, (int) (this.d.a / 1000), this.d.b, this.d.c, jSONObject);
    }

    protected void onSessionSucceeded() {
        if (this.j.b == 3) {
            i.f().a(this.e, new al(this));
        } else if (this.j.b == 0) {
            this.f.setReadingProgress(this.b.getReadingProgress());
            this.h.a(this.b, this.f, this.g);
        } else {
            this.h.a(this.b, this.j.c, this.g);
        }
    }

    protected void onSessionFailed() {
        this.h.a(this.b, this.i.c.getString(com.duokan.b.i.general__shared__network_error), this.g);
    }
}
