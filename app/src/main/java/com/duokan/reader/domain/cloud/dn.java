package com.duokan.reader.domain.cloud;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.a;
import com.duokan.reader.domain.account.ab;

class dn extends ef {
    final /* synthetic */ ab a;
    final /* synthetic */ dm b;
    private final eg d = new eg();
    private ei e = null;

    dn(dm dmVar, ab abVar) {
        this.b = dmVar;
        this.a = abVar;
        super(dmVar.a.b);
    }

    protected void onSessionTry() {
        if (this.a.a()) {
            this.d.b = true;
            this.d.a = true;
            return;
        }
        this.e = new ei(this.a);
        this.e.a();
        this.d.a(this.b.a.b.a(this.e));
        this.d.a = true;
        this.d.b = true;
    }

    protected void onSessionSucceeded() {
        if (this.a.a(DkUserPurchasedFictionsManager.g())) {
            this.b.a.b.h = this.d;
            this.b.a.b.f();
            this.b.a.b.g.a(null);
            this.b.a.b.g.b();
            return;
        }
        this.b.a.b.g.a(-1, "");
        this.b.a.b.g.b();
    }

    protected void onSessionFailed() {
        this.b.a.b.g.a(-1, "");
        this.b.a.b.g.b();
    }

    protected boolean onSessionException(Exception exception, int i) {
        a.c().a(LogLevel.ERROR, "pm", "unexpected error while full-loading purchased fictions.", (Throwable) exception);
        if (this.e != null) {
            this.e.clearInfo();
            this.e.clearItems();
        }
        return super.onSessionException(exception, i);
    }
}
