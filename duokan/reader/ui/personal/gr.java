package com.duokan.reader.ui.personal;

import com.duokan.c.j;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.o;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.cloud.PersonalPrefs;

class gr extends hh {
    final ab a = new ab(i.f().b(PersonalAccount.class));
    int b = 0;
    final /* synthetic */ fl c;
    private b e = null;
    private b f = null;
    private b g = null;

    gr(fl flVar) {
        this.c = flVar;
        super(flVar);
    }

    protected void onSessionTry() {
        o oVar = new o(this, this.a);
        this.e = oVar.b(0);
        this.f = oVar.b(1);
        this.g = oVar.b();
    }

    protected void onSessionSucceeded() {
        if (PersonalPrefs.a().a(this.a)) {
            if (this.e.b == 0) {
                this.b = ((Integer) this.e.a).intValue() + this.b;
            }
            if (this.f.b == 0) {
                this.b = ((Integer) this.f.a).intValue() + this.b;
            }
            if (this.g.b == 0) {
                this.b = ((Integer) this.g.a).intValue() + this.b;
            }
        }
        this.c.m.setText(this.c.getString(j.personal__account_summary_view__my_coupon) + this.b);
    }

    protected void onSessionFailed() {
        this.c.m.setText(this.c.getString(j.personal__account_summary_view__my_coupon) + this.b);
    }
}
