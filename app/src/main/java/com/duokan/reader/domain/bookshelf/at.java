package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.ab;

import java.util.List;

class at extends bp {
    final /* synthetic */ as a;

    at(as asVar, ab abVar, List list, boolean z, iq iqVar) {
        this.a = asVar;
        super(asVar.b, abVar, list, z, iqVar);
    }

    protected void onSessionSucceeded() {
        super.onSessionSucceeded();
        this.a.b.x();
    }

    protected void onSessionFailed() {
        super.onSessionFailed();
        this.a.b.x();
    }
}
