package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.al;
import java.util.List;

class bl extends bo {
    /* renamed from: a */
    final /* synthetic */ bk f2843a;

    bl(bk bkVar, al alVar, List list, boolean z, ik ikVar) {
        this.f2843a = bkVar;
        super(bkVar.f2833b, alVar, list, z, ikVar);
    }

    protected void onSessionSucceeded() {
        super.onSessionSucceeded();
        this.f2843a.f2833b.m3949x();
    }

    protected void onSessionFailed() {
        super.onSessionFailed();
        this.f2843a.f2833b.m3949x();
    }
}
