package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.DkSignInInfo;
import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.common.webservices.duokan.s;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.ab;

class kq extends r {
    b a = new b();
    final ab b = new ab(this.d.d.b(PersonalAccount.class));
    final /* synthetic */ boolean c;
    final /* synthetic */ kp d;

    kq(kp kpVar, boolean z) {
        this.d = kpVar;
        this.c = z;
    }

    protected void onSessionTry() {
        this.a = new s(this, this.b).a();
    }

    protected void onSessionSucceeded() {
        if (this.a.b == 0) {
            if (this.d.e.a(this.b)) {
                ((DkSignInInfo) this.a.a).mLottery = this.d.b(((DkSignInInfo) this.a.a).mSignStatus, ((DkSignInInfo) this.a.a).mToday, ((DkSignInInfo) this.a.a).mLottery);
                this.d.a(((DkSignInInfo) this.a.a).mSignStatus, ((DkSignInInfo) this.a.a).mToday, ((DkSignInInfo) this.a.a).mLottery);
            }
            this.d.a(this.c);
            return;
        }
        this.d.a(this.c);
    }

    protected void onSessionFailed() {
        this.d.a(this.c);
    }
}
