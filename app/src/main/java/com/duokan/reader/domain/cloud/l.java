package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.DkSyncService;
import com.duokan.reader.common.webservices.duokan.b;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.i;

import java.util.HashMap;
import java.util.Iterator;

class l extends b {
    final /* synthetic */ a a;
    final /* synthetic */ String b;
    final /* synthetic */ k c;
    private com.duokan.reader.common.webservices.b d = null;

    l(k kVar, a aVar, String str) {
        this.c = kVar;
        this.a = aVar;
        this.b = str;
    }

    protected void onSessionTry() {
        DkSyncService dkSyncService = new DkSyncService((WebSession) this, this.a);
        if (this.c.a != null && this.c.a.length() > 0) {
            dkSyncService.a(this.c.a);
        }
        this.d = dkSyncService.a();
    }

    protected void onSessionSucceeded() {
        if (!this.c.d.d.a(this.a)) {
            this.c.b.a("");
        } else if (this.d.b == 3) {
            if (this.c.c) {
                i.f().a(this.b, new m(this));
            } else {
                this.c.b.a(this.d.c);
            }
        } else if (this.d.b != 0) {
            this.c.b.a(this.d.c);
        } else {
            DkCloudStatisticsInfo a = this.c.d.a(this.a, false);
            a.update(this.d);
            if (this.c.a != null && this.c.a.length() > 0) {
                HashMap hashMap = new HashMap(a.mNewDistribution);
                Iterator keys = this.c.a.keys();
                while (keys.hasNext()) {
                    try {
                        hashMap.remove(Long.valueOf(Long.parseLong((String) keys.next())));
                    } catch (Throwable th) {
                    }
                }
                a.mNewDistribution = hashMap;
            }
            this.c.d.a(a);
            this.c.d.j();
            this.c.b.a();
        }
    }

    protected void onSessionFailed() {
        this.c.b.a(this.c.d.c.getString(com.duokan.b.i.general__shared__network_error));
    }
}
