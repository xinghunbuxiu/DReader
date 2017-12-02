package com.duokan.reader.ui.account;

import android.text.TextUtils;

import com.duokan.c.j;
import com.duokan.reader.common.b.a;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.domain.account.MiAccount;
import com.duokan.reader.domain.account.a.c;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.ui.general.*;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;

do;

class p extends r {
    final /* synthetic */ a a;
    final /* synthetic */ String b;
    final /* synthetic */ do c;
    final /* synthetic */ String d;
    final /* synthetic */ m e;
    private b f = null;
    private boolean g = false;

    p(m mVar, a aVar, String str, do doVar, String str2) {
        this.e = mVar;
        this.a = aVar;
        this.b = str;
        this.c = doVar;
        this.d = str2;
    }

    protected void onSessionTry() {
        c cVar = new c(this);
        try {
            if (this.a.i() != null) {
                this.f = cVar.f(this.b);
            }
        } catch (AuthenticationFailureException e) {
            this.g = true;
            throw e;
        }
    }

    protected void onSessionSucceeded() {
        if (this.f.b == 0) {
            ((MiAccount) i.f().b(MiAccount.class)).f(this.b);
            this.c.a();
        } else if (TextUtils.isEmpty(this.f.c)) {
            this.c.a(this.e.getContext().getResources().getString(j.personal__miaccount_change_nickname_view__failed));
        } else {
            this.c.a(this.f.c);
        }
    }

    protected void onSessionFailed() {
        if (this.g) {
            this.a.a("com.xiaomi", this.d);
            this.e.a(this.b, this.c);
            return;
        }
        this.c.a(this.e.getContext().getResources().getString(j.general__shared__network_error));
    }
}
