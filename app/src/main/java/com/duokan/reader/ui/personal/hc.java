package com.duokan.reader.ui.personal;

import com.duokan.p024c.C0258j;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.duokan.C0640n;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.cloud.PersonalPrefs;

class hc extends hu {
    /* renamed from: a */
    final al f8636a = new al(C0709k.m3476a().m3502b(PersonalAccount.class));
    /* renamed from: b */
    int f8637b = 0;
    /* renamed from: c */
    final /* synthetic */ fz f8638c;
    /* renamed from: e */
    private C0621a<Integer> f8639e = null;

    hc(fz fzVar) {
        this.f8638c = fzVar;
        super(fzVar);
    }

    protected void onSessionTry() {
        this.f8639e = new C0640n(this, this.f8636a).m2910a();
    }

    protected void onSessionSucceeded() {
        if (PersonalPrefs.m5175a().m5209a(this.f8636a) && this.f8639e.b == 0) {
            this.f8637b = ((Integer) this.f8639e.f2058a).intValue();
        }
        this.f8638c.f8588o.setText(this.f8638c.getString(C0258j.personal__account_summary_view__my_reward) + this.f8637b);
    }

    protected void onSessionFailed() {
        this.f8638c.f8588o.setText(this.f8638c.getString(C0258j.personal__account_summary_view__my_reward) + this.f8637b);
    }
}
