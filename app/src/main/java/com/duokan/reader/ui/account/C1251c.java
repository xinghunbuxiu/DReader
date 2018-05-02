package com.duokan.reader.ui.account;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.os.Bundle;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.ui.general.C1329do;

/* renamed from: com.duokan.reader.ui.account.c */
class C1251c implements AccountManagerCallback<Bundle> {
    /* renamed from: a */
    final /* synthetic */ String f5908a;
    /* renamed from: b */
    final /* synthetic */ C1329do f5909b;
    /* renamed from: c */
    final /* synthetic */ C1249a f5910c;

    C1251c(C1249a c1249a, String str, C1329do c1329do) {
        this.f5910c = c1249a;
        this.f5908a = str;
        this.f5909b = c1329do;
    }

    public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
        try {
            this.f5910c.m8856a(this.f5908a, ((Bundle) accountManagerFuture.getResult()).getString("authtoken"), this.f5909b);
        } catch (Exception e) {
            e.printStackTrace();
            String str = "";
            if (C0559f.m2476b().m2486e()) {
                str = this.f5910c.getContext().getResources().getString(C0258j.personal__miaccount_change_nickname_view__failed);
            } else {
                str = DkApp.get().getApplicationContext().getResources().getString(C0258j.general__shared__network_error);
            }
            this.f5909b.mo1781a(str);
        }
    }
}
