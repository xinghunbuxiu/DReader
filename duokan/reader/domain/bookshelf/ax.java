package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.ab;

class ax extends ir {
    final /* synthetic */ ab a;
    final /* synthetic */ aw b;

    ax(aw awVar, ab abVar, ab abVar2) {
        this.b = awVar;
        this.a = abVar2;
        super(awVar.b, abVar);
    }

    protected void onSessionSucceeded() {
        super.onSessionSucceeded();
        if (this.a.a(this.b.b.j)) {
            this.b.b.b(this.b.a);
        }
    }
}
