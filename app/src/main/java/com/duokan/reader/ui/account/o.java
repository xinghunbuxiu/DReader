package com.duokan.reader.ui.account;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.os.Bundle;

import com.duokan.c.j;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.c.f;

do;

class o implements AccountManagerCallback {
    final /* synthetic */ String a;
    final /* synthetic */ do b;
    final /* synthetic */ m c;

    o(m mVar, String str, do doVar) {
        this.c = mVar;
        this.a = str;
        this.b = doVar;
    }

    public void run(AccountManagerFuture accountManagerFuture) {
        try {
            this.c.a(this.a, ((Bundle) accountManagerFuture.getResult()).getString("authtoken"), this.b);
        } catch (Exception e) {
            e.printStackTrace();
            String str = "";
            if (f.b().e()) {
                str = this.c.getContext().getResources().getString(j.personal__miaccount_change_nickname_view__failed);
            } else {
                str = DkApp.get().getApplicationContext().getResources().getString(j.general__shared__network_error);
            }
            this.b.a(str);
        }
    }
}
