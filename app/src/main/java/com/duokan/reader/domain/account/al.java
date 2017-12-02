package com.duokan.reader.domain.account;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;

import com.duokan.reader.DkApp;
import com.duokan.reader.common.b.a;

class al implements AccountManagerCallback {
    final /* synthetic */ a a;
    final /* synthetic */ AccountManagerCallback b;
    final /* synthetic */ be c;
    final /* synthetic */ MiAccount d;

    al(MiAccount miAccount, a aVar, AccountManagerCallback accountManagerCallback, be beVar) {
        this.d = miAccount;
        this.a = aVar;
        this.b = accountManagerCallback;
        this.c = beVar;
    }

    public void run(AccountManagerFuture accountManagerFuture) {
        Account i = this.a.i();
        if (i != null) {
            this.a.a(i, "reader", null, DkApp.get().getTopActivity(), this.b);
        } else {
            this.c.b(null, "");
        }
    }
}
