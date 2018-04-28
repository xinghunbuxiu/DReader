package com.duokan.reader.ui.bookshelf;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.duokan.C0640n;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.cloud.PersonalPrefs;

class in extends jd {
    /* renamed from: a */
    final al f6621a = new al(C0709k.m3476a().m3502b(PersonalAccount.class));
    /* renamed from: b */
    int f6622b = 0;
    /* renamed from: c */
    final /* synthetic */ ie f6623c;
    /* renamed from: e */
    private C0621a<Integer> f6624e = null;

    in(ie ieVar) {
        this.f6623c = ieVar;
        super(ieVar);
    }

    protected void onSessionTry() {
        this.f6624e = new C0640n(this, this.f6621a).m2917b(2);
    }

    protected void onSessionSucceeded() {
        if (PersonalPrefs.m5175a().m5209a(this.f6621a) && this.f6624e.b == 0) {
            this.f6622b = ((Integer) this.f6624e.f2058a).intValue();
        }
        this.f6623c.f6595g.setText(String.valueOf(this.f6622b));
    }

    protected void onSessionFailed() {
        this.f6623c.f6595g.setText(String.valueOf(this.f6622b));
    }
}
