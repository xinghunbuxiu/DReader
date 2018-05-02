package com.duokan.reader.domain.cloud;

import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.al;

class br extends WebSession {
    /* renamed from: a */
    final /* synthetic */ al f3775a;
    /* renamed from: b */
    final /* synthetic */ bq f3776b;
    /* renamed from: c */
    private final ch f3777c = new ch();
    /* renamed from: d */
    private cj f3778d = null;

    br(bq bqVar, C0657i c0657i, al alVar) {
        this.f3776b = bqVar;
        this.f3775a = alVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        if (this.f3775a.m3364a()) {
            this.f3777c.f3813b = true;
            this.f3777c.f3812a = true;
            return;
        }
        this.f3778d = new cj(this.f3775a);
        this.f3778d.m5406a();
        this.f3777c.m5398a(this.f3776b.f3774b.m5041b(this.f3778d));
        this.f3777c.f3812a = true;
    }

    protected void onSessionSucceeded() {
        if (this.f3775a.m3365a(DkUserPurchasedBooksManager.m5051h())) {
            this.f3776b.f3774b.f3608h = this.f3777c;
            this.f3776b.f3774b.m5048f();
            this.f3776b.f3774b.f3606f.mo730a(null);
            this.f3776b.f3774b.f3606f.m2234b();
            return;
        }
        this.f3776b.f3774b.f3606f.mo729a(-1, "");
        this.f3776b.f3774b.f3606f.m2234b();
    }

    protected void onSessionFailed() {
        this.f3776b.f3774b.f3606f.mo729a(-1, "");
        this.f3776b.f3774b.f3606f.m2234b();
    }

    protected boolean onSessionException(Exception exception, int i) {
        WebLog.init().printStackTrace(LogLevel.ERROR, "pm", "unexpected error while partial-loading purchased books.", (Throwable) exception);
        if (this.f3778d != null) {
            this.f3778d.clearInfo();
            this.f3778d.clearItems();
        }
        return super.onSessionException(exception, i);
    }
}
