package com.duokan.reader.ui.personal;

import com.duokan.c.j;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.o;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.cloud.PersonalPrefs;

class gp extends hh {
    final ab a = new ab(i.f().b(PersonalAccount.class));
    int b = 0;
    final /* synthetic */ fl c;
    private b e = null;

    gp(fl flVar) {
        this.c = flVar;
        super(flVar);
    }

    protected void onSessionTry() {
        this.e = new o(this, this.a).a();
    }

    protected void onSessionSucceeded() {
        if (PersonalPrefs.a().a(this.a) && this.e.b == 0) {
            this.b = ((Integer) this.e.a).intValue();
        }
        this.c.o.setText(this.c.getString(j.personal__account_summary_view__my_reward) + this.b);
    }

    protected void onSessionFailed() {
        this.c.o.setText(this.c.getString(j.personal__account_summary_view__my_reward) + this.b);
    }
}
