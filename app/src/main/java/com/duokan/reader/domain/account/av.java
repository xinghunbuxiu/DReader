package com.duokan.reader.domain.account;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.common.b.a;

class av implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ b b;
    final /* synthetic */ MiAccount c;

    av(MiAccount miAccount, a aVar, b bVar) {
        this.c = miAccount;
        this.a = aVar;
        this.b = bVar;
    }

    public void run() {
        this.a.d();
        com.duokan.core.diagnostic.a.c().c(LogLevel.EVENT, "miaccount", "login(system)");
        MiAccount.e.a(this.c, this.b);
    }
}
