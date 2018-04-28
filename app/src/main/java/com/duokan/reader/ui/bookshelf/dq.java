package com.duokan.reader.ui.bookshelf;

import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.cloud.PersonalPrefs;

class dq implements Runnable {
    /* renamed from: a */
    final /* synthetic */ dp f6355a;

    dq(dp dpVar) {
        this.f6355a = dpVar;
    }

    public void run() {
        PersonalPrefs.m5175a().m5230g(false);
        C0709k.m3476a().m3497a(PersonalAccount.class, new dr(this));
    }
}
