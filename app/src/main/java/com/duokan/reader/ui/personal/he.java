package com.duokan.reader.ui.personal;

import com.duokan.p024c.C0258j;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.duokan.C0640n;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import java.util.ArrayList;
import java.util.List;

class he extends hu {
    /* renamed from: a */
    final al f8644a = new al(C0709k.m3476a().m3502b(PersonalAccount.class));
    /* renamed from: b */
    int f8645b = 0;
    /* renamed from: c */
    final /* synthetic */ fz f8646c;
    /* renamed from: e */
    private C0621a<Integer> f8647e = null;
    /* renamed from: f */
    private C0621a<Integer> f8648f = null;

    he(fz fzVar) {
        this.f8646c = fzVar;
        super(fzVar);
    }

    protected void onSessionTry() {
        C0640n c0640n = new C0640n(this, this.f8644a);
        List arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(2));
        this.f8647e = c0640n.m2913a(-1, arrayList);
        this.f8648f = c0640n.m2916b();
    }

    protected void onSessionSucceeded() {
        if (PersonalPrefs.m5175a().m5209a(this.f8644a)) {
            if (this.f8647e.b == 0) {
                this.f8645b = ((Integer) this.f8647e.f2058a).intValue() + this.f8645b;
            }
            if (this.f8648f.b == 0) {
                this.f8645b = ((Integer) this.f8648f.f2058a).intValue() + this.f8645b;
            }
        }
        this.f8646c.f8586m.setText(this.f8646c.getString(C0258j.personal__account_summary_view__my_coupon) + this.f8645b);
    }

    protected void onSessionFailed() {
        this.f8646c.f8586m.setText(this.f8646c.getString(C0258j.personal__account_summary_view__my_coupon) + this.f8645b);
    }
}
