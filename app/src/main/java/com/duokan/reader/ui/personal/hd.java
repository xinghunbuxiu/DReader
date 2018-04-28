package com.duokan.reader.ui.personal;

import com.duokan.p024c.C0258j;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.duokan.C0640n;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.cloud.PersonalPrefs;

class hd extends hu {
    /* renamed from: a */
    final al f8640a = new al(C0709k.m3476a().m3502b(PersonalAccount.class));
    /* renamed from: b */
    int f8641b = 0;
    /* renamed from: c */
    final /* synthetic */ fz f8642c;
    /* renamed from: e */
    private C0621a<Integer> f8643e = null;

    hd(fz fzVar) {
        this.f8642c = fzVar;
        super(fzVar);
    }

    protected void onSessionTry() {
        this.f8643e = new C0640n(this, this.f8640a).m2917b(2);
    }

    protected void onSessionSucceeded() {
        if (PersonalPrefs.m5175a().m5209a(this.f8640a) && this.f8643e.b == 0) {
            this.f8641b = ((Integer) this.f8643e.f2058a).intValue();
        }
        this.f8642c.f8587n.setText(this.f8642c.getString(C0258j.personal__account_summary_view__my_cash) + this.f8641b);
    }

    protected void onSessionFailed() {
        this.f8642c.f8587n.setText(this.f8642c.getString(C0258j.personal__account_summary_view__my_cash) + this.f8641b);
    }
}
