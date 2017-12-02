package com.duokan.reader.domain.account;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.a;

class at implements Runnable {
    final /* synthetic */ b a;
    final /* synthetic */ MiAccount b;

    at(MiAccount miAccount, b bVar) {
        this.b = miAccount;
        this.a = bVar;
    }

    public void run() {
        a.c().c(LogLevel.EVENT, "miaccount", "login(local or system)");
        i.f().a(MiAccount.class, new au(this));
    }
}
