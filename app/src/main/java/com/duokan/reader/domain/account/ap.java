package com.duokan.reader.domain.account;

import android.accounts.Account;

import com.duokan.b.i;

class ap implements Runnable {
    final /* synthetic */ bc a;
    final /* synthetic */ bd b;
    final /* synthetic */ Account c;
    final /* synthetic */ MiAccount d;

    ap(MiAccount miAccount, bc bcVar, bd bdVar, Account account) {
        this.d = miAccount;
        this.a = bcVar;
        this.b = bdVar;
        this.c = account;
    }

    public void run() {
        this.a.close();
        this.b.b(this.c, this.d.a.a(i.general__shared__network_error));
    }
}
