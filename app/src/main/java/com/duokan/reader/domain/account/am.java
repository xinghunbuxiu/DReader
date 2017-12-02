package com.duokan.reader.domain.account;

import android.accounts.AccountManagerFuture;

class am implements Runnable {
    final /* synthetic */ AccountManagerFuture a;
    final /* synthetic */ MiAccount b;

    am(MiAccount miAccount, AccountManagerFuture accountManagerFuture) {
        this.b = miAccount;
        this.a = accountManagerFuture;
    }

    public void run() {
        this.a.cancel(true);
    }
}
