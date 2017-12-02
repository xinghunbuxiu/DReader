package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.ab;

import java.util.List;

class bo extends ix {
    final /* synthetic */ bn a;

    bo(bn bnVar, ab abVar, List list, iq iqVar) {
        this.a = bnVar;
        super(bnVar.f, abVar, list, iqVar);
    }

    protected void onSessionSucceeded() {
        super.onSessionSucceeded();
        if (this.a.a.isCancelled()) {
            this.a.f.x();
            return;
        }
        this.a.f.t();
        this.a.f.c(this.a.c, this.a.d, this.a.e, this.a.b, this.a.a);
    }

    protected void onSessionFailed() {
        super.onSessionFailed();
        this.a.f.x();
        if (!this.a.a.isCancelled()) {
            this.a.f.i("");
        }
    }
}
