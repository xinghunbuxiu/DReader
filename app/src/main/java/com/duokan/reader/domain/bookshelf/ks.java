package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;

import com.duokan.b.i;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.DkSignInInfo;
import com.duokan.reader.common.webservices.duokan.DkStoreAdInfo;
import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.common.webservices.duokan.s;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.ui.general.be;

class ks extends r {
    b a = new b();
    b b = new b();
    final /* synthetic */ ab c;
    final /* synthetic */ kr d;

    ks(kr krVar, ab abVar) {
        this.d = krVar;
        this.c = abVar;
    }

    protected void onSessionTry() {
        boolean z = true;
        s sVar = new s(this, this.c);
        this.a = sVar.b();
        try {
            if (this.d.a.e.b() != 1) {
                z = false;
            }
            this.b = sVar.a(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected void onSessionSucceeded() {
        if (this.a.b == 1001 || this.a.b == 1002 || this.a.b == 1003) {
            this.d.a.d.a(this.c.a, new kt(this));
        } else if (this.a.b != 0) {
            this.d.a.e();
            if (TextUtils.isEmpty(this.a.c)) {
                CharSequence string;
                if (this.a.b == 14) {
                    string = this.d.a.b.getResources().getString(i.general__shared__local_time_error);
                } else {
                    string = String.format(this.d.a.b.getString(i.general__shared__unknown_error_code), new Object[]{Integer.valueOf(this.a.b)});
                }
                be.a(this.d.a.b, string, 0).show();
            } else {
                be.a(this.d.a.b, this.a.c, 0).show();
            }
            this.d.a.b(true);
        } else if (this.d.a.e.a(this.c)) {
            ((DkSignInInfo) this.a.a).mLottery = this.d.a.b(((DkSignInInfo) this.a.a).mSignStatus, ((DkSignInInfo) this.a.a).mToday, ((DkSignInInfo) this.a.a).mLottery);
            this.d.a.a(((DkSignInInfo) this.a.a).mSignStatus, ((DkSignInInfo) this.a.a).mToday, ((DkSignInInfo) this.a.a).mLottery);
            this.d.a.a(((DkSignInInfo) this.a.a).mSignStatus, ((DkSignInInfo) this.a.a).mToday, ((DkSignInInfo) this.a.a).mReward, ((DkSignInInfo) this.a.a).mLottery, ((DkSignInInfo) this.a.a).mHasPhysical, false, false, 0, (DkStoreAdInfo[]) this.b.a);
        } else {
            this.d.a.e();
            be.a(this.d.a.b, i.general__shared__account_change, 0).show();
        }
    }

    protected void onSessionCancelled() {
        this.d.a.e();
    }

    protected void onSessionClosed() {
        this.d.a.h = null;
    }

    protected void onSessionFailed() {
        this.d.a.e();
        be.a(this.d.a.b, this.d.a.b.getString(i.general__shared__network_error), 0).show();
    }
}
