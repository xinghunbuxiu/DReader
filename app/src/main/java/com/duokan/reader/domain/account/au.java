package com.duokan.reader.domain.account;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.os.Bundle;
import com.duokan.p023b.C0247i;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.p037c.C0559f;

class au implements AccountManagerCallback<Bundle> {
    /* renamed from: a */
    final /* synthetic */ Account f2376a;
    /* renamed from: b */
    final /* synthetic */ Activity f2377b;
    /* renamed from: c */
    final /* synthetic */ C0700d f2378c;
    /* renamed from: d */
    final /* synthetic */ MiAccount f2379d;

    au(MiAccount miAccount, Account account, Activity activity, C0700d c0700d) {
        this.f2379d = miAccount;
        this.f2376a = account;
        this.f2377b = activity;
        this.f2378c = c0700d;
    }

    public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
        try {
            this.f2379d.m3181a(this.f2376a, this.f2377b, ((Bundle) accountManagerFuture.getResult()).getString("authtoken"), this.f2378c);
        } catch (Exception e) {
            e.printStackTrace();
            String str = "";
            if (!C0559f.m2476b().m2486e()) {
                str = DkApp.get().getApplicationContext().getResources().getString(C0247i.general__shared__network_error);
            }
            this.f2378c.mo869a(this.f2379d, str);
        }
    }
}
