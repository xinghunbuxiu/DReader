package com.duokan.reader.ui.bookshelf;

import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.cloud.PersonalPrefs;

class dj implements Runnable {
    final /* synthetic */ di a;

    dj(di diVar) {
        this.a = diVar;
    }

    public void run() {
        PersonalPrefs.a().g(false);
        i.f().a(PersonalAccount.class, new dk(this));
    }
}
