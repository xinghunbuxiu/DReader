package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.ab;

class by extends ap {
    final /* synthetic */ ab a;
    final /* synthetic */ bx b;

    by(bx bxVar, ab abVar) {
        this.b = bxVar;
        this.a = abVar;
    }

    protected void onSessionTry() {
        new br(this.a).a();
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }
}
