package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.ab;

class ch extends ap {
    final /* synthetic */ ab a;
    final /* synthetic */ cw b;
    final /* synthetic */ bv c;
    private final cs d = new cs();

    ch(bv bvVar, ab abVar, cw cwVar) {
        this.c = bvVar;
        this.a = abVar;
        this.b = cwVar;
    }

    protected void onSessionTry() {
        br brVar = new br(this.a);
        brVar.a();
        this.d.a(brVar);
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
