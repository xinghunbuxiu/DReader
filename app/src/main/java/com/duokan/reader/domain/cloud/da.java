package com.duokan.reader.domain.cloud;

import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.al;

class da extends WebSession {
    /* renamed from: a */
    final /* synthetic */ al f3851a;
    /* renamed from: b */
    final /* synthetic */ cz f3852b;
    /* renamed from: c */
    private final dr f3853c = new dr();
    /* renamed from: d */
    private dt f3854d = null;

    da(cz czVar, C0657i c0657i, al alVar) {
        this.f3852b = czVar;
        this.f3851a = alVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        if (this.f3851a.m3364a()) {
            this.f3853c.f3889b = true;
            this.f3853c.f3888a = true;
            return;
        }
        this.f3854d = new dt(this.f3851a);
        this.f3854d.m5468a();
        this.f3853c.m5461a(this.f3852b.f3850a.f3849b.m5075a(this.f3854d));
        this.f3853c.f3888a = true;
        this.f3853c.f3889b = true;
    }

    protected void onSessionSucceeded() {
        if (this.f3851a.m3365a(DkUserPurchasedFictionsManager.m5092g())) {
            this.f3852b.f3850a.f3849b.f3616h = this.f3853c;
            this.f3852b.f3850a.f3849b.m5091f();
            this.f3852b.f3850a.f3849b.f3615g.mo730a(null);
            this.f3852b.f3850a.f3849b.f3615g.m2234b();
            return;
        }
        this.f3852b.f3850a.f3849b.f3615g.mo729a(-1, "");
        this.f3852b.f3850a.f3849b.f3615g.m2234b();
    }

    protected void onSessionFailed() {
        this.f3852b.f3850a.f3849b.f3615g.mo729a(-1, "");
        this.f3852b.f3850a.f3849b.f3615g.m2234b();
    }

    protected boolean onSessionException(Exception exception, int i) {
        C0328a.m757c().m748a(LogLevel.ERROR, "pm", "unexpected error while full-loading purchased fictions.", (Throwable) exception);
        if (this.f3854d != null) {
            this.f3854d.clearInfo();
            this.f3854d.clearItems();
        }
        return super.onSessionException(exception, i);
    }
}
