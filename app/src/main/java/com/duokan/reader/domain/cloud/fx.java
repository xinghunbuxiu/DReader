package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.DkStoreOrderInfo;
import com.duokan.reader.common.webservices.duokan.aa;
import com.duokan.reader.common.webservices.duokan.b;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.store.m;

class fx extends b {
    final /* synthetic */ String a;
    final /* synthetic */ fw b;
    private com.duokan.reader.common.webservices.b c = null;

    fx(fw fwVar, String str) {
        this.b = fwVar;
        this.a = str;
    }

    protected void onSessionTry() {
        this.c = new aa((WebSession) this, this.b.a).c(this.a, this.b.b.mBookUuid);
    }

    protected void onSessionSucceeded() {
        if (this.c.b == 1001 || this.c.b == 1002 || this.c.b == 1003) {
            i.f().a(this.b.c, new fy(this));
        } else if (this.c.b != 0) {
            this.b.d.c.a(String.format(this.b.d.d.c.getString(com.duokan.b.i.bookcity_store__shared__fail_to_create_order_as_error), new Object[]{Integer.valueOf(this.c.b)}));
        } else {
            this.b.d.d.a(new m((DkStoreOrderInfo) this.c.a, this.b.b), this.a, new fz(this));
        }
    }

    protected void onSessionFailed() {
        this.b.d.c.a(this.b.d.d.c.getString(com.duokan.b.i.bookcity_store__shared__fail_to_create_order_as_network_error));
    }
}
