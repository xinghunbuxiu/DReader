package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;

class gl implements Runnable {
    /* renamed from: a */
    final /* synthetic */ gk f3240a;

    gl(gk gkVar) {
        this.f3240a = gkVar;
    }

    public void run() {
        C0709k.m3476a().m3497a(PersonalAccount.class, new gm(this));
    }
}
