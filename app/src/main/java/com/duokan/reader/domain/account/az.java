package com.duokan.reader.domain.account;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.os.Bundle;

import com.duokan.b.i;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.c.f;

class az implements AccountManagerCallback {
    final /* synthetic */ Account a;
    final /* synthetic */ Activity b;
    final /* synthetic */ d c;
    final /* synthetic */ MiAccount d;

    az(MiAccount miAccount, Account account, Activity activity, d dVar) {
        this.d = miAccount;
        this.a = account;
        this.b = activity;
        this.c = dVar;
    }

    public void run(AccountManagerFuture accountManagerFuture) {
        try {
            this.d.a(this.a, this.b, ((Bundle) accountManagerFuture.getResult()).getString("authtoken"), this.c);
        } catch (Exception e) {
            e.printStackTrace();
            String str = "";
            if (!f.b().e()) {
                str = DkApp.get().getApplicationContext().getResources().getString(i.general__shared__network_error);
            }
            this.c.a(this.d, str);
        }
    }
}
