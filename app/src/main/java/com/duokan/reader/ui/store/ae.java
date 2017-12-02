package com.duokan.reader.ui.store;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.aa;
import com.duokan.reader.common.webservices.duokan.b;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;

import java.util.Arrays;

class ae extends b {
    final /* synthetic */ a a;
    final /* synthetic */ ad b;
    private com.duokan.reader.common.webservices.b c;

    ae(ad adVar, a aVar) {
        this.b = adVar;
        this.a = aVar;
    }

    protected void onSessionTry() {
        this.c = new aa((WebSession) this, this.a).b(this.b.a, this.b.b);
    }

    protected void onSessionSucceeded() {
        if (this.c.b == 0) {
            DkUserPurchasedFictionsManager.a().a(this.b.a, Arrays.asList(new String[]{this.b.b}), new af(this));
            return;
        }
        this.b.c.a(this.b.a, this.b.b, Integer.valueOf(this.c.b));
    }

    protected void onSessionFailed() {
        this.b.c.a(this.b.a, this.b.b, null);
    }
}
