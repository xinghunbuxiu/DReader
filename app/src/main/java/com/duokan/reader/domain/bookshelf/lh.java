package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;
import com.duokan.p023b.C0247i;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0644r;
import com.duokan.reader.common.webservices.duokan.DkSignInInfo;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.ui.general.be;

class lh extends WebSession {
    /* renamed from: a */
    C0621a<DkSignInInfo> f3545a = new C0621a();
    /* renamed from: b */
    final al f3546b = new al(this.f3547c.f3524d.m3502b(PersonalAccount.class));
    /* renamed from: c */
    final /* synthetic */ lb f3547c;

    lh(lb lbVar, C0657i c0657i) {
        this.f3547c = lbVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f3545a = new C0644r(this, this.f3546b).m3001a();
    }

    protected void onSessionSucceeded() {
        if (this.f3545a.b != 0) {
            this.f3547c.m4926f();
            if (TextUtils.isEmpty(this.f3545a.c)) {
                CharSequence string;
                if (this.f3545a.b == 14) {
                    string = this.f3547c.f3522b.getResources().getString(C0247i.general__shared__local_time_error);
                } else {
                    string = String.format(this.f3547c.f3522b.getString(C0247i.general__shared__unknown_error_code), new Object[]{Integer.valueOf(this.f3545a.b)});
                }
                be.m10287a(this.f3547c.f3522b, string, 0).show();
                return;
            }
            be.m10287a(this.f3547c.f3522b, this.f3545a.c, 0).show();
        } else if (this.f3547c.f3525e.m5209a(this.f3546b)) {
            ((DkSignInInfo) this.f3545a.f2058a).mLottery = this.f3547c.m4905b(((DkSignInInfo) this.f3545a.f2058a).mSignStatus, ((DkSignInInfo) this.f3545a.f2058a).mToday, ((DkSignInInfo) this.f3545a.f2058a).mLottery);
            this.f3547c.m4900a(((DkSignInInfo) this.f3545a.f2058a).mSignStatus, ((DkSignInInfo) this.f3545a.f2058a).mToday, ((DkSignInInfo) this.f3545a.f2058a).mLottery);
            this.f3547c.m4899a(((DkSignInInfo) this.f3545a.f2058a).mSignStatus, ((DkSignInInfo) this.f3545a.f2058a).mToday, ((DkSignInInfo) this.f3545a.f2058a).mReward, ((DkSignInInfo) this.f3545a.f2058a).mLottery, false, false);
        } else {
            this.f3547c.m4926f();
            be.m10286a(this.f3547c.f3522b, C0247i.general__shared__account_change, 0).show();
        }
    }

    protected void onSessionFailed() {
        this.f3547c.m4926f();
        be.m10287a(this.f3547c.f3522b, this.f3547c.f3522b.getString(C0247i.general__shared__network_error), 0).show();
    }
}
