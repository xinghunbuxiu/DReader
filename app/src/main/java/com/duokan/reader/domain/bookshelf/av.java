package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.ab;

import java.util.List;

class av extends bp {
    final /* synthetic */ au a;

    av(au auVar, ab abVar, List list, boolean z, iq iqVar) {
        this.a = auVar;
        super(auVar.f, abVar, list, z, iqVar);
    }

    protected void onSessionSucceeded() {
        super.onSessionSucceeded();
        if (!this.a.a.isCancelled()) {
            this.a.f.a(this.a.e);
            this.a.f.p();
        }
    }

    protected void onSessionFailed() {
        super.onSessionFailed();
        this.a.f.x();
        if (!this.a.a.isCancelled()) {
            this.a.f.i("");
        }
    }
}
