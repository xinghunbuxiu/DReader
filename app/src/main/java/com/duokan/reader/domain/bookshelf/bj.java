package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.al;
import java.util.List;

class bj extends ir {
    /* renamed from: a */
    final /* synthetic */ bi f2831a;

    bj(bi biVar, al alVar, List list, ik ikVar) {
        this.f2831a = biVar;
        super(biVar.f2830f, alVar, list, ikVar);
    }

    protected void onSessionSucceeded() {
        super.onSessionSucceeded();
        if (this.f2831a.f2825a.isCancelled()) {
            this.f2831a.f2830f.m3949x();
            return;
        }
        this.f2831a.f2830f.m3945t();
        this.f2831a.f2830f.m3968c(this.f2831a.f2827c, this.f2831a.f2828d, this.f2831a.f2829e, this.f2831a.f2826b, this.f2831a.f2825a);
    }

    protected void onSessionFailed() {
        super.onSessionFailed();
        this.f2831a.f2830f.m3949x();
        if (!this.f2831a.f2825a.isCancelled()) {
            this.f2831a.f2830f.m3933i("");
        }
    }
}
