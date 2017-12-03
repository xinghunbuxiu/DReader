package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.ab;

class dn extends ap {
    final /* synthetic */ ab a;
    final /* synthetic */ eb b;
    final /* synthetic */ dh c;
    private df d;

    dn(dh dhVar, ab abVar, eb ebVar) {
        this.c = dhVar;
        this.a = abVar;
        this.b = ebVar;
    }

    protected void onSessionTry() {
        dd ddVar = new dd(this.a);
        ddVar.a();
        this.d = ddVar.b();
    }

    protected void onSessionSucceeded() {
        if (this.a.a(this.c.c)) {
            this.c.a(this.d, new do (this));
            return;
        }
        this.b.a("");
        a();
    }

    protected void onSessionFailed() {
        this.b.a("");
        a();
    }

    private void a() {
        this.c.g.poll();
        this.c.d();
    }
}
