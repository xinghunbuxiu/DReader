package com.duokan.reader.ui.personal;

import com.duokan.c.j;
import com.duokan.core.ui.dv;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.k;
import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.ui.general.be;
import com.xiaomi.passport.accountmanager.MiAccountManager;

import java.util.Collection;

class bs extends r {
    b a = new b();
    final /* synthetic */ int b;
    final /* synthetic */ bo c;

    bs(bo boVar, int i) {
        this.c = boVar;
        this.b = i;
    }

    protected void onSessionTry() {
        this.a = new k(this, MiAccountManager.get(this.c.getContext())).a(this.c.d, this.b);
    }

    protected void onSessionSucceeded() {
        if (this.a.b == 0) {
            this.c.b.addAll((Collection) this.a.a);
        } else {
            be.a(this.c.getContext(), this.a.c, 0).show();
        }
        this.c.a.getAdapter().a(false);
        dv.a(this.c.a, new bt(this));
    }

    protected void onSessionFailed() {
        be.a(this.c.getContext(), j.general__shared__network_error, 0).show();
    }
}
