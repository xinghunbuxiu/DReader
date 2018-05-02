package com.duokan.reader.domain.account;

import com.duokan.reader.common.b.a;

class ad implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ MiAccount b;

    ad(MiAccount miAccount, a aVar) {
        this.b = miAccount;
        this.a = aVar;
    }

    public void run() {
        this.a.d();
    }
}
