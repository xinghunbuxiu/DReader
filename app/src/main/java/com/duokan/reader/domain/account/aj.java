package com.duokan.reader.domain.account;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.os.Bundle;

import com.duokan.b.i;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.b.a;
import com.duokan.reader.common.classc;

class aj implements AccountManagerCallback {
    final /* synthetic */ boolean a;
    final /* synthetic */ be b;
    final /* synthetic */ a c;
    final /* synthetic */ Account d;
    final /* synthetic */ MiAccount e;

    aj(MiAccount miAccount, boolean z, be beVar, a aVar, Account account) {
        this.e = miAccount;
        this.a = z;
        this.b = beVar;
        this.c = aVar;
        this.d = account;
    }

    public void run(AccountManagerFuture accountManagerFuture) {
        String string;
        try {
            string = ((Bundle) accountManagerFuture.getResult()).getString("authtoken");
            this.e.a(string, this.a, new ak(this, string), 0);
        } catch (Exception e) {
            e.printStackTrace();
            string = "";
            if (!classc.ConnectivityReceiver.b().e()) {
                string = DkApp.get().getApplicationContext().getResources().getString(i.general__shared__network_error);
            }
            this.b.b(this.d, string);
        }
    }
}
