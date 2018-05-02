package com.duokan.reader.domain.account;

import android.accounts.Account;
import android.app.Activity;
import android.text.TextUtils;

import com.duokan.reader.common.b.a;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.domain.account.a.c;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;

class ba extends bc {
    final /* synthetic */ String a;
    final /* synthetic */ a b;
    final /* synthetic */ Account c;
    final /* synthetic */ d d;
    final /* synthetic */ Activity e;
    final /* synthetic */ MiAccount f;
    private b g = null;
    private b h = null;
    private String i = this.a;
    private boolean j = false;

    ba(MiAccount miAccount, String str, a aVar, Account account, d dVar, Activity activity) {
        this.f = miAccount;
        this.a = str;
        this.b = aVar;
        this.c = account;
        this.d = dVar;
        this.e = activity;
    }

    protected void onSessionTry() {
        if (TextUtils.isEmpty(this.i)) {
            this.i = this.b.a(this.c, "passportapi", false);
        }
        c cVar = new c(this);
        ExtendedAuthToken.parse(this.i);
        try {
            this.h = cVar.a(this.c);
            this.g = new com.duokan.reader.domain.social.b.a(this, this.f).f(this.f.f);
        } catch (AuthenticationFailureException e) {
            this.j = true;
            throw e;
        }
    }

    protected void onSessionSucceeded() {
        if (this.g.b == 0) {
            this.f.h.e.b.a((com.duokan.reader.domain.social.b.c) this.g.a);
            this.f.h.e.a.mIsVip = this.f.h.e.b.b;
        }
        if (this.h.b == 0) {
            this.f.h.e.a.mIconUrl = ((bh) this.h.a).e.a.mIconUrl;
            this.f.h.e.a.mNickName = ((bh) this.h.a).e.a.mNickName;
            this.f.h.c = ((bh) this.h.a).c;
            this.f.h.d = ((bh) this.h.a).d;
            this.f.l();
            this.f.a.c(this.f);
            if (this.d != null) {
                this.d.a(this.f);
            }
        } else if (this.d != null) {
            this.d.a(this.f, this.h.c);
        }
    }

    protected void onSessionFailed() {
        if (this.j) {
            this.b.a("com.xiaomi", this.a);
            if (this.e != null) {
                this.f.a(this.e, this.d);
            } else {
                this.d.a(this.f, "");
            }
        } else if (this.d != null) {
            this.d.a(this.f, this.f.a.a(i.general__shared__network_error));
        }
    }
}
