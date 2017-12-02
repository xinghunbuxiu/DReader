package com.duokan.reader.domain.payment;

import com.duokan.core.sys.ag;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.aa;
import com.duokan.reader.common.webservices.duokan.b;
import com.duokan.reader.domain.account.a;

class o extends b {
    final /* synthetic */ a a;
    final /* synthetic */ String b;
    final /* synthetic */ s c;
    final /* synthetic */ String d;
    final /* synthetic */ ag e;
    final /* synthetic */ PaymentManager f;
    private com.duokan.reader.common.webservices.b g = null;
    private boolean h = false;

    o(PaymentManager paymentManager, a aVar, String str, s sVar, String str2, ag agVar) {
        this.f = paymentManager;
        this.a = aVar;
        this.b = str;
        this.c = sVar;
        this.d = str2;
        this.e = agVar;
    }

    protected void onSessionTry() {
        this.g = new aa((WebSession) this, this.a).a(this.b, this.c, this.d);
    }

    protected void onSessionSucceeded() {
        if (this.g.b == 0) {
            this.e.a(PaymentResult.VERIFIED_OK);
        } else if (this.g.b == 20020) {
            this.e.a(PaymentResult.VERIFIED_NOT_ENOUGH);
        } else {
            this.e.a(PaymentResult.UNVERIFIED);
        }
    }

    protected void onSessionFailed() {
        this.e.a(PaymentResult.UNVERIFIED);
    }
}
