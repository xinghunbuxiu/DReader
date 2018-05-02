package com.duokan.reader.domain.payment;

import com.duokan.core.sys.ag;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0652z;
import com.duokan.reader.domain.account.C0672a;

/* renamed from: com.duokan.reader.domain.payment.o */
class C1102o extends WebSession {
    /* renamed from: a */
    final /* synthetic */ C0672a f5365a;
    /* renamed from: b */
    final /* synthetic */ String f5366b;
    /* renamed from: c */
    final /* synthetic */ C1089s f5367c;
    /* renamed from: d */
    final /* synthetic */ String f5368d;
    /* renamed from: e */
    final /* synthetic */ ag f5369e;
    /* renamed from: f */
    final /* synthetic */ PaymentManager f5370f;
    /* renamed from: g */
    private C0621a<Void> f5371g = null;
    /* renamed from: h */
    private boolean f5372h = false;

    C1102o(PaymentManager paymentManager, C0657i c0657i, C0672a c0672a, String str, C1089s c1089s, String str2, ag agVar) {
        this.f5370f = paymentManager;
        this.f5365a = c0672a;
        this.f5366b = str;
        this.f5367c = c1089s;
        this.f5368d = str2;
        this.f5369e = agVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f5371g = new C0652z((WebSession) this, this.f5365a).m3057a(this.f5366b, this.f5367c, this.f5368d);
    }

    protected void onSessionSucceeded() {
        if (this.f5371g.b == 0) {
            this.f5369e.run(PaymentResult.VERIFIED_OK);
        } else if (this.f5371g.b == 20020) {
            this.f5369e.run(PaymentResult.VERIFIED_NOT_ENOUGH);
        } else {
            this.f5369e.run(PaymentResult.UNVERIFIED);
        }
    }

    protected void onSessionFailed() {
        this.f5369e.run(PaymentResult.UNVERIFIED);
    }
}
