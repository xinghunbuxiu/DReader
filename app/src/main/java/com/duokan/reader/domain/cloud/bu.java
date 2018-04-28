package com.duokan.reader.domain.cloud;

import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.al;

class bu extends WebSession {
    /* renamed from: a */
    final /* synthetic */ al f3782a;
    /* renamed from: b */
    final /* synthetic */ bt f3783b;
    /* renamed from: c */
    private final ch f3784c = new ch();
    /* renamed from: d */
    private cj f3785d = null;

    bu(bt btVar, C0657i c0657i, al alVar) {
        this.f3783b = btVar;
        this.f3782a = alVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        if (this.f3782a.m3364a()) {
            this.f3784c.f3813b = true;
            this.f3784c.f3812a = true;
            return;
        }
        this.f3785d = new cj(this.f3782a);
        this.f3785d.m5406a();
        this.f3784c.m5398a(this.f3783b.f3781a.f3780b.m5032a(this.f3785d));
        this.f3784c.f3812a = true;
        this.f3784c.f3813b = true;
    }

    protected void onSessionSucceeded() {
        if (this.f3782a.m3365a(DkUserPurchasedBooksManager.m5051h())) {
            this.f3783b.f3781a.f3780b.f3608h = this.f3784c;
            this.f3783b.f3781a.f3780b.m5048f();
            this.f3783b.f3781a.f3780b.f3607g.mo730a(null);
            this.f3783b.f3781a.f3780b.f3607g.m2234b();
            return;
        }
        this.f3783b.f3781a.f3780b.f3607g.mo729a(-1, "");
        this.f3783b.f3781a.f3780b.f3607g.m2234b();
    }

    protected void onSessionFailed() {
        this.f3783b.f3781a.f3780b.f3607g.mo729a(-1, "");
        this.f3783b.f3781a.f3780b.f3607g.m2234b();
    }

    protected boolean onSessionException(Exception exception, int i) {
        C0328a.m757c().m748a(LogLevel.ERROR, "pm", "unexpected error while full-loading purchased books.", (Throwable) exception);
        if (this.f3785d != null) {
            this.f3785d.clearInfo();
            this.f3785d.clearItems();
        }
        return super.onSessionException(exception, i);
    }
}
