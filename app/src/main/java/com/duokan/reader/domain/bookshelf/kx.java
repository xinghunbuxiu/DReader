package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;

import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.DkSignInInfo;
import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.common.webservices.duokan.s;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.ui.general.be;

class kx extends r {
    b a = new b();
    final /* synthetic */ ab b;
    final /* synthetic */ kw c;

    kx(kw kwVar, ab abVar) {
        this.c = kwVar;
        this.b = abVar;
    }

    protected void onSessionTry() {
        this.a = new s(this, this.b).d();
    }

    protected void onSessionSucceeded() {
        if (this.a.b == 1001 || this.a.b == 1002 || this.a.b == 1003) {
            i.f().a(this.b.a, new ky(this));
        } else if (this.a.b != 0) {
            this.c.a.e();
            if (TextUtils.isEmpty(this.a.c)) {
                CharSequence string;
                if (this.a.b == 14) {
                    string = this.c.a.b.getResources().getString(com.duokan.b.i.general__shared__local_time_error);
                } else {
                    string = String.format(this.c.a.b.getString(com.duokan.b.i.general__shared__unknown_error_code), new Object[]{Integer.valueOf(this.a.b)});
                }
                be.a(this.c.a.b, string, 0).show();
            } else {
                be.a(this.c.a.b, this.a.c, 0).show();
            }
            this.c.a.b(true);
        } else if (this.c.a.e.a(this.b)) {
            this.c.a.e.b(((DkSignInInfo) this.a.a).mLottery);
            this.c.a.a(((DkSignInInfo) this.a.a).mSignStatus, ((DkSignInInfo) this.a.a).mToday, ((DkSignInInfo) this.a.a).mReward, ((DkSignInInfo) this.a.a).mLottery, ((DkSignInInfo) this.a.a).mHasPhysical, true, false, 0, null);
        } else {
            this.c.a.e();
            be.a(this.c.a.b, com.duokan.b.i.general__shared__account_change, 0).show();
        }
    }

    protected void onSessionCancelled() {
        this.c.a.e();
    }

    protected void onSessionClosed() {
        this.c.a.i = null;
    }

    protected void onSessionFailed() {
        this.c.a.e();
        be.a(this.c.a.b, this.c.a.b.getString(com.duokan.b.i.general__shared__network_error), 0).show();
    }
}
