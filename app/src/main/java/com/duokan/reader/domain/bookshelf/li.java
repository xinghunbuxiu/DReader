package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.p023b.C0247i;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0644r;
import com.duokan.reader.common.webservices.duokan.DkSignInInfo;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.ui.general.be;
import java.util.List;

class li extends WebSession {
    /* renamed from: a */
    C0621a<DkSignInInfo> f3548a = new C0621a();
    /* renamed from: b */
    int f3549b = this.f3552e.m4914a(this.f3552e.f3525e.m5235k(), this.f3552e.f3525e.m5236l());
    /* renamed from: c */
    final al f3550c = new al(this.f3552e.f3524d.m3502b(PersonalAccount.class));
    /* renamed from: d */
    final /* synthetic */ List f3551d;
    /* renamed from: e */
    final /* synthetic */ lb f3552e;

    li(lb lbVar, C0657i c0657i, List list) {
        this.f3552e = lbVar;
        this.f3551d = list;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f3548a = new C0644r(this, this.f3550c).m3001a();
    }

    protected void onSessionSucceeded() {
        if (this.f3548a.b == 0) {
            WebLog.init().w(this.f3549b > 0);
            if (this.f3552e.f3525e.m5209a(this.f3550c)) {
                ((DkSignInInfo) this.f3548a.f2058a).mLottery = this.f3552e.m4905b(((DkSignInInfo) this.f3548a.f2058a).mSignStatus, ((DkSignInInfo) this.f3548a.f2058a).mToday, ((DkSignInInfo) this.f3548a.f2058a).mLottery);
                this.f3552e.m4900a(((DkSignInInfo) this.f3548a.f2058a).mSignStatus, ((DkSignInInfo) this.f3548a.f2058a).mToday, ((DkSignInInfo) this.f3548a.f2058a).mLottery);
                if (this.f3549b > 0) {
                    this.f3552e.m4899a(((DkSignInInfo) this.f3548a.f2058a).mSignStatus, ((DkSignInInfo) this.f3548a.f2058a).mToday, this.f3551d, ((DkSignInInfo) this.f3548a.f2058a).mLottery, false, true);
                    return;
                }
                this.f3552e.m4926f();
                this.f3552e.m4919a(true);
                return;
            }
            this.f3552e.m4926f();
            be.m10286a(this.f3552e.f3522b, C0247i.general__shared__account_change, 0).show();
            return;
        }
        this.f3552e.m4926f();
        if (TextUtils.isEmpty(this.f3548a.c)) {
            CharSequence string;
            if (this.f3548a.b == 14) {
                string = this.f3552e.f3522b.getResources().getString(C0247i.general__shared__local_time_error);
            } else {
                string = String.format(this.f3552e.f3522b.getString(C0247i.general__shared__unknown_error_code), new Object[]{Integer.valueOf(this.f3548a.b)});
            }
            be.m10287a(this.f3552e.f3522b, string, 0).show();
            return;
        }
        be.m10287a(this.f3552e.f3522b, this.f3548a.c, 0).show();
    }

    protected void onSessionFailed() {
        this.f3552e.m4926f();
        be.m10287a(this.f3552e.f3522b, this.f3552e.f3522b.getString(C0247i.general__shared__network_error), 0).show();
    }
}
