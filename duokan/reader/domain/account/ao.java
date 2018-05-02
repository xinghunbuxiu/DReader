package com.duokan.reader.domain.account;

import android.accounts.Account;
import android.text.TextUtils;

import com.alipay.android.client.Aes;
import com.duokan.b.i;
import com.duokan.reader.DkApp;
import com.duokan.reader.UmengManager;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.domain.account.a.a;

import java.util.HashMap;

class ao extends bc {
    final /* synthetic */ String a;
    final /* synthetic */ Account b;
    final /* synthetic */ bd c;
    final /* synthetic */ boolean d;
    final /* synthetic */ String e;
    final /* synthetic */ MiAccount f;
    private b g = null;

    ao(MiAccount miAccount, String str, Account account, bd bdVar, boolean z, String str2) {
        this.f = miAccount;
        this.a = str;
        this.b = account;
        this.c = bdVar;
        this.d = z;
        this.e = str2;
    }

    protected void onSessionTry() {
        this.g = new com.duokan.reader.domain.account.a.b(this).a(this.b.name, Aes.encrypt_Base64(this.a, "s87PfD3FczE5z01XaB6YacbG9lQc20A3"));
    }

    protected void onSessionSucceeded() {
        String str = null;
        if (this.g.b != 0) {
            this.c.b(this.b, this.g.c);
            return;
        }
        if (TextUtils.equals(this.f.g, ((a) this.g.a).a)) {
            HashMap hashMap = new HashMap();
            hashMap.put("TokenDuplicated", this.f.g);
            UmengManager.get().onEvent("ERROR_TRACK_V1", hashMap);
        } else {
            g bhVar = new bh(this.b.name);
            Account j = com.duokan.reader.common.b.a.a(DkApp.get()).j();
            if (j == null) {
                bhVar.a = this.d ? this.e : null;
            } else {
                if (this.d && !TextUtils.equals(j.name, this.b.name)) {
                    str = this.e;
                }
                bhVar.a = str;
            }
            bhVar.b = this.a;
            this.f.j = new cf(this.b.name, ((a) this.g.a).a, bhVar);
        }
        this.c.a(this.b, ((a) this.g.a).a);
    }

    protected void onSessionFailed() {
        this.c.b(this.b, this.f.a.a(i.general__shared__network_error));
    }
}
