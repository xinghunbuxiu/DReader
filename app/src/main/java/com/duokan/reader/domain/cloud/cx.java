package com.duokan.reader.domain.cloud;

import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.al;

class cx extends WebSession {
    /* renamed from: a */
    final /* synthetic */ al f3844a;
    /* renamed from: b */
    final /* synthetic */ cw f3845b;
    /* renamed from: c */
    private final dr f3846c = new dr();
    /* renamed from: d */
    private dt f3847d = null;

    cx(cw cwVar, C0657i c0657i, al alVar) {
        this.f3845b = cwVar;
        this.f3844a = alVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        if (this.f3844a.m3364a()) {
            this.f3846c.f3889b = true;
            this.f3846c.f3888a = true;
            return;
        }
        this.f3847d = new dt(this.f3844a);
        this.f3847d.m5468a();
        this.f3846c.m5461a(this.f3845b.f3843b.m5084b(this.f3847d));
        this.f3846c.f3888a = true;
    }

    protected void onSessionSucceeded() {
        if (this.f3844a.m3365a(DkUserPurchasedFictionsManager.m5092g())) {
            this.f3845b.f3843b.f3616h = this.f3846c;
            this.f3845b.f3843b.m5091f();
            this.f3845b.f3843b.f3614f.mo730a(null);
            this.f3845b.f3843b.f3614f.m2234b();
            return;
        }
        this.f3845b.f3843b.f3614f.mo729a(-1, "");
        this.f3845b.f3843b.f3614f.m2234b();
    }

    protected void onSessionFailed() {
        this.f3845b.f3843b.f3614f.mo729a(-1, "");
        this.f3845b.f3843b.f3614f.m2234b();
    }

    protected boolean onSessionException(Exception exception, int i) {
        WebLog.init().printStackTrace(LogLevel.ERROR, "pm", "unexpected error while partial-loading purchased fictions.", (Throwable) exception);
        if (this.f3847d != null) {
            this.f3847d.clearInfo();
            this.f3847d.clearItems();
        }
        return super.onSessionException(exception, i);
    }
}
