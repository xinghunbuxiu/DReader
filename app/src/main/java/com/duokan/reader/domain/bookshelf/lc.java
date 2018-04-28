package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0644r;
import com.duokan.reader.common.webservices.duokan.DkSignInInfo;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.al;

class lc extends WebSession {
    /* renamed from: a */
    C0621a<DkSignInInfo> f3532a = new C0621a();
    /* renamed from: b */
    final al f3533b = new al(this.f3535d.f3524d.m3502b(PersonalAccount.class));
    /* renamed from: c */
    final /* synthetic */ boolean f3534c;
    /* renamed from: d */
    final /* synthetic */ lb f3535d;

    lc(lb lbVar, C0657i c0657i, boolean z) {
        this.f3535d = lbVar;
        this.f3534c = z;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f3532a = new C0644r(this, this.f3533b).m3001a();
    }

    protected void onSessionSucceeded() {
        if (this.f3532a.b == 0) {
            if (this.f3535d.f3525e.m5209a(this.f3533b)) {
                ((DkSignInInfo) this.f3532a.f2058a).mLottery = this.f3535d.m4905b(((DkSignInInfo) this.f3532a.f2058a).mSignStatus, ((DkSignInInfo) this.f3532a.f2058a).mToday, ((DkSignInInfo) this.f3532a.f2058a).mLottery);
                this.f3535d.m4900a(((DkSignInInfo) this.f3532a.f2058a).mSignStatus, ((DkSignInInfo) this.f3532a.f2058a).mToday, ((DkSignInInfo) this.f3532a.f2058a).mLottery);
            }
            this.f3535d.m4919a(this.f3534c);
            return;
        }
        this.f3535d.m4919a(this.f3534c);
    }

    protected void onSessionFailed() {
        this.f3535d.m4919a(this.f3534c);
    }
}
