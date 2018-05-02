package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.ab;

import java.util.List;

class bm extends ix {
    final /* synthetic */ bl a;

    bm(bl blVar, ab abVar, List list, iq iqVar) {
        this.a = blVar;
        super(blVar.b, abVar, list, iqVar);
    }

    protected void onSessionSucceeded() {
        super.onSessionSucceeded();
        if (this.a.a.a(this.a.b.j)) {
            this.a.b.c(this.a.a);
        } else {
            this.a.b.x();
        }
    }

    protected void onSessionFailed() {
        super.onSessionFailed();
        this.a.b.x();
    }
}
