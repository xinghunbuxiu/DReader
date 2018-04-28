package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.al;

class au extends il {
    /* renamed from: a */
    final /* synthetic */ al f2784a;
    /* renamed from: b */
    final /* synthetic */ at f2785b;

    au(at atVar, al alVar, al alVar2) {
        this.f2785b = atVar;
        this.f2784a = alVar2;
        super(atVar.f2778b, alVar);
    }

    protected void onSessionSucceeded() {
        super.onSessionSucceeded();
        if (this.f2784a.m3365a(this.f2785b.f2778b.j)) {
            this.f2785b.f2778b.m3962b(this.f2785b.f2777a);
        }
    }
}
