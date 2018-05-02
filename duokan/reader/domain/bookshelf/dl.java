package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.ab;

class dl extends ap {
    final /* synthetic */ ab a;
    final /* synthetic */ dz b;
    final /* synthetic */ dh c;
    private final ea d = new ea();

    dl(dh dhVar, ab abVar, dz dzVar) {
        this.c = dhVar;
        this.a = abVar;
        this.b = dzVar;
    }

    protected void onSessionTry() {
        dd ddVar = new dd(this.a);
        ddVar.a();
        this.d.a(ddVar);
    }

    protected void onSessionSucceeded() {
        if (this.a.a(this.c.c)) {
            this.c.a(this.d);
            if (this.b != null) {
                this.b.a();
            }
        } else if (this.b != null) {
            this.b.b();
        }
    }

    protected void onSessionFailed() {
        if (this.b != null) {
            this.b.b();
        }
    }
}
