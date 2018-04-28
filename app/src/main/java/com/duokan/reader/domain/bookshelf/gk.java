package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import java.util.concurrent.Semaphore;

class gk implements Runnable {
    /* renamed from: a */
    final /* synthetic */ gq f3237a;
    /* renamed from: b */
    final /* synthetic */ Semaphore f3238b;
    /* renamed from: c */
    final /* synthetic */ gj f3239c;

    gk(gj gjVar, gq gqVar, Semaphore semaphore) {
        this.f3239c = gjVar;
        this.f3237a = gqVar;
        this.f3238b = semaphore;
    }

    public void run() {
        Runnable glVar = new gl(this);
        if (((PersonalAccount) C0709k.m3476a().m3502b(PersonalAccount.class)).mo839i()) {
            gq gqVar = this.f3237a;
            gqVar.f3248a++;
            this.f3239c.f3236c.mo2477a("", new gp(this, glVar));
            return;
        }
        glVar.run();
    }
}
