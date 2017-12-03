package com.duokan.reader.domain.account;

import com.duokan.reader.DkApp;

class ay implements Runnable {
    final /* synthetic */ c a;
    final /* synthetic */ MiAccount b;

    ay(MiAccount miAccount, c cVar) {
        this.b = miAccount;
        this.a = cVar;
    }

    public void run() {
        a.a(DkApp.get()).d();
        this.a.a(this.b);
        this.b.a.b(this.b);
        this.b.y();
    }
}
