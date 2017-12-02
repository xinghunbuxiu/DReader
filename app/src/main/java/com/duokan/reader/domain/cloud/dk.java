package com.duokan.reader.domain.cloud;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.a;
import com.duokan.reader.domain.account.ab;

class dk extends ef {
    final /* synthetic */ ab a;
    final /* synthetic */ dj b;
    private final eg d = new eg();
    private ei e = null;

    dk(dj djVar, ab abVar) {
        this.b = djVar;
        this.a = abVar;
        super(djVar.b);
    }

    protected void onSessionTry() {
        if (this.a.a()) {
            this.d.b = true;
            this.d.a = true;
            return;
        }
        this.e = new ei(this.a);
        this.e.a();
        this.d.a(this.b.b.b(this.e));
        this.d.a = true;
    }

    protected void onSessionSucceeded() {
        if (this.a.a(DkUserPurchasedFictionsManager.g())) {
            this.b.b.h = this.d;
            this.b.b.f();
            this.b.b.f.a(null);
            this.b.b.f.b();
            return;
        }
        this.b.b.f.a(-1, "");
        this.b.b.f.b();
    }

    protected void onSessionFailed() {
        this.b.b.f.a(-1, "");
        this.b.b.f.b();
    }

    protected boolean onSessionException(Exception exception, int i) {
        a.c().a(LogLevel.ERROR, "pm", "unexpected error while partial-loading purchased fictions.", (Throwable) exception);
        if (this.e != null) {
            this.e.clearInfo();
            this.e.clearItems();
        }
        return super.onSessionException(exception, i);
    }
}
