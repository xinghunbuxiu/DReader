package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.al;
import java.util.List;

class bh extends ir {
    /* renamed from: a */
    final /* synthetic */ bg f2824a;

    bh(bg bgVar, al alVar, List list, ik ikVar) {
        this.f2824a = bgVar;
        super(bgVar.f2816b, alVar, list, ikVar);
    }

    protected void onSessionSucceeded() {
        super.onSessionSucceeded();
        if (this.f2824a.f2815a.m3365a(this.f2824a.f2816b.j)) {
            this.f2824a.f2816b.m3966c(this.f2824a.f2815a);
        } else {
            this.f2824a.f2816b.m3949x();
        }
    }

    protected void onSessionFailed() {
        super.onSessionFailed();
        this.f2824a.f2816b.m3949x();
    }
}
