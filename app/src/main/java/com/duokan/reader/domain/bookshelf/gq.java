package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.i;

import java.util.concurrent.Semaphore;

class gq implements Runnable {
    final /* synthetic */ gw a;
    final /* synthetic */ Semaphore b;
    final /* synthetic */ gp c;

    gq(gp gpVar, gw gwVar, Semaphore semaphore) {
        this.c = gpVar;
        this.a = gwVar;
        this.b = semaphore;
    }

    public void run() {
        Runnable grVar = new gr(this);
        if (((PersonalAccount) i.f().b(PersonalAccount.class)).i()) {
            gw gwVar = this.a;
            gwVar.a++;
            this.c.c.a("", new gv(this, grVar));
            return;
        }
        grVar.run();
    }
}
