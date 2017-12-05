package com.duokan.reader.ui.personal;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.os.Bundle;

import com.duokan.c.j;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.classc;

class de implements AccountManagerCallback {
    final /* synthetic */ da a;

    de(da daVar) {
        this.a = daVar;
    }

    public void run(AccountManagerFuture accountManagerFuture) {
        try {
            this.a.a(((Bundle) accountManagerFuture.getResult()).getString("authtoken"));
        } catch (Exception e) {
            e.printStackTrace();
            String str = "";
            if (!classc.ConnectivityReceiver.b().e()) {
                str = DkApp.get().getApplicationContext().getResources().getString(j.general__shared__network_error);
            }
            this.a.f.a(str);
        }
    }
}
