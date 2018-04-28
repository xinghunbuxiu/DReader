package com.duokan.reader.ui.personal;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.os.Bundle;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.p037c.C0559f;

class cx implements AccountManagerCallback<Bundle> {
    /* renamed from: a */
    final /* synthetic */ ct f8435a;

    cx(ct ctVar) {
        this.f8435a = ctVar;
    }

    public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
        try {
            this.f8435a.m11629a(((Bundle) accountManagerFuture.getResult()).getString("authtoken"));
        } catch (Exception e) {
            e.printStackTrace();
            String str = "";
            if (!C0559f.m2476b().m2486e()) {
                str = DkApp.get().getApplicationContext().getResources().getString(C0258j.general__shared__network_error);
            }
            this.f8435a.f8428f.mo1895a(str);
        }
    }
}
