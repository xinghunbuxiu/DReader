package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.al;
import java.util.List;

class bn extends bo {
    /* renamed from: a */
    final /* synthetic */ bm f2850a;

    bn(bm bmVar, al alVar, List list, boolean z, ik ikVar) {
        this.f2850a = bmVar;
        super(bmVar.f2849f, alVar, list, z, ikVar);
    }

    protected void onSessionSucceeded() {
        super.onSessionSucceeded();
        if (!this.f2850a.f2844a.isCancelled()) {
            this.f2850a.f2849f.m3973a(this.f2850a.f2848e);
            this.f2850a.f2849f.m3941p();
        }
    }

    protected void onSessionFailed() {
        super.onSessionFailed();
        this.f2850a.f2849f.m3949x();
        if (!this.f2850a.f2844a.isCancelled()) {
            this.f2850a.f2849f.m3933i("");
        }
    }
}
