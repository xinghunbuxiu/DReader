package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.aa;
import com.duokan.reader.common.webservices.duokan.b;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.i;

class ft extends b {
    final /* synthetic */ a a;
    final /* synthetic */ String b;
    final /* synthetic */ fs c;
    private com.duokan.reader.common.webservices.b d = null;

    ft(fs fsVar, a aVar, String str) {
        this.c = fsVar;
        this.a = aVar;
        this.b = str;
    }

    protected void onSessionTry() {
        this.d = new aa((WebSession) this, this.a).d(this.c.a.getLinkUrl(), this.c.b);
    }

    protected void onSessionSucceeded() {
        if (this.d.b == 1001 || this.d.b == 1002 || this.d.b == 1003) {
            i.f().a(this.b, new fu(this));
        } else if (this.d == null || this.d.b != 0) {
            this.c.c.a(this.d.c);
        } else {
            this.c.a.setMessage(this.c.b);
            this.c.c.a(this.c.a);
        }
    }

    protected void onSessionFailed() {
        this.c.c.a(this.c.d.c.getString(com.duokan.b.i.general__shared__network_error));
    }
}
