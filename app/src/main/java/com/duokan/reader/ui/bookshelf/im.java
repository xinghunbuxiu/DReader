package com.duokan.reader.ui.bookshelf;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.duokan.C0640n;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.cloud.PersonalPrefs;

class im extends jd {
    /* renamed from: a */
    final al f6617a = new al(C0709k.m3476a().m3502b(PersonalAccount.class));
    /* renamed from: b */
    int f6618b = 0;
    /* renamed from: c */
    final /* synthetic */ ie f6619c;
    /* renamed from: e */
    private C0621a<Integer> f6620e = null;

    im(ie ieVar) {
        this.f6619c = ieVar;
        super(ieVar);
    }

    protected void onSessionTry() {
        this.f6620e = new C0640n(this, this.f6617a).m2910a();
    }

    protected void onSessionSucceeded() {
        if (PersonalPrefs.m5175a().m5209a(this.f6617a) && this.f6620e.b == 0) {
            this.f6618b = ((Integer) this.f6620e.f2058a).intValue();
        }
        this.f6619c.f6597i.setText(String.valueOf(this.f6618b));
    }

    protected void onSessionFailed() {
        this.f6619c.f6597i.setText(String.valueOf(this.f6618b));
    }
}
