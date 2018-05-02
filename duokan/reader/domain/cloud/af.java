package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.DkSyncService;
import com.duokan.reader.common.webservices.duokan.b;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.i;
import com.mipay.sdk.Mipay;

import org.w3c.dom.Node;

class af extends b {
    final /* synthetic */ a a;
    final /* synthetic */ String b;
    final /* synthetic */ ae c;
    private com.duokan.reader.common.webservices.b d = null;

    af(ae aeVar, a aVar, String str) {
        this.c = aeVar;
        this.a = aVar;
        this.b = str;
    }

    protected void onSessionTry() {
        this.d = new DkSyncService((WebSession) this, this.a).a(this.c.a, this.c.b, 0);
    }

    protected void onSessionSucceeded() {
        if (this.d.b == 3) {
            i.f().a(this.b, new ag(this));
        } else if (this.d.b == 0 || this.d.b == 7) {
            try {
                this.c.d.a(new DkCloudReadingInfo(this.c.b, this.c.c, (Node) this.d.a, com.duokan.reader.common.e.a.a(com.duokan.reader.common.e.a.f((Node) this.d.a, Mipay.KEY_RESULT), "latestversion")));
            } catch (Exception e) {
                e.printStackTrace();
                this.c.d.a("");
            }
        } else {
            this.c.d.a(this.d.c);
        }
    }

    protected void onSessionFailed() {
        this.c.d.a(this.c.e.c.getString(com.duokan.b.i.general__shared__network_error));
    }
}
