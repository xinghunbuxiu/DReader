package com.duokan.reader.domain.account;

import android.content.Context;

import com.duokan.b.i;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.domain.social.b.a;

class aq extends bc {
    final /* synthetic */ String a;
    final /* synthetic */ bb b;
    final /* synthetic */ Context c;
    final /* synthetic */ MiAccount d;
    private b e = null;

    aq(MiAccount miAccount, String str, bb bbVar, Context context) {
        this.d = miAccount;
        this.a = str;
        this.b = bbVar;
        this.c = context;
    }

    protected void onSessionTry() {
        this.e = new a(this, this.d).e(this.a);
    }

    protected void onSessionSucceeded() {
        if (this.e.b == 0) {
            this.d.h.e.b.i = this.a;
            this.d.l();
            this.d.a.c(this.d);
            this.b.a();
        } else if (this.e.b == 1001 || this.e.b == 1002 || this.e.b == 1003) {
            i.f().a(this.d.f, new ar(this));
        } else {
            this.b.a(this.e.b, this.e.c);
        }
    }

    protected void onSessionFailed() {
        this.b.a(-1, this.c.getResources().getString(i.general__shared__network_error));
    }
}
