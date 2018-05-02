package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.i;

class gr implements Runnable {
    final /* synthetic */ gq a;

    gr(gq gqVar) {
        this.a = gqVar;
    }

    public void run() {
        i.f().a(PersonalAccount.class, new gs(this));
    }
}
