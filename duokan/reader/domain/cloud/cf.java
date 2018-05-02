package com.duokan.reader.domain.cloud;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.domain.account.ab;

class cf extends cs {
    final /* synthetic */ ab a;
    final /* synthetic */ ce b;
    private final ct d = new ct();
    private cv e = null;

    cf(ce ceVar, ab abVar) {
        this.b = ceVar;
        this.a = abVar;
        super(ceVar.a.b);
    }

    protected void onSessionTry() {
        if (this.a.a()) {
            this.d.b = true;
            this.d.a = true;
            return;
        }
        this.e = new cv(this.a);
        this.e.a();
        this.d.a(this.b.a.b.a(this.e));
        this.d.a = true;
        this.d.b = true;
    }

    protected void onSessionSucceeded() {
        if (this.a.a(DkUserPurchasedBooksManager.h())) {
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
        a.c().a(LogLevel.ERROR, "pm", "unexpected error while full-loading purchased books.", (Throwable) exception);
        if (this.e != null) {
            this.e.clearInfo();
            this.e.clearItems();
        }
        return super.onSessionException(exception, i);
    }
}
