package com.duokan.reader.domain.bookshelf;

class ik extends ap {
    final /* synthetic */ hi a;

    ik(hi hiVar) {
        this.a = hiVar;
    }

    protected void onSessionTry() {
        this.a.u();
        this.a.b(this.a.F(), true);
    }

    protected void onSessionSucceeded() {
        this.a.x();
    }

    protected void onSessionFailed() {
        this.a.x();
    }
}
