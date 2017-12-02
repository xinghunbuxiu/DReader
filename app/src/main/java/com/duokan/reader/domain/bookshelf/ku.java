package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;

import com.duokan.b.i;
import com.duokan.core.diagnostic.a;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.DkSignInInfo;
import com.duokan.reader.common.webservices.duokan.DkStoreAdInfo;
import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.common.webservices.duokan.s;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.ui.general.be;

import java.util.List;

class ku extends r {
    b a = new b();
    b b = new b();
    int c = this.f.a(this.f.e.k(), this.f.e.l());
    final ab d = new ab(this.f.d.b(PersonalAccount.class));
    final /* synthetic */ List e;
    final /* synthetic */ kp f;

    ku(kp kpVar, List list) {
        this.f = kpVar;
        this.e = list;
    }

    protected void onSessionTry() {
        boolean z = true;
        s sVar = new s(this, this.d);
        this.a = sVar.a();
        try {
            if (this.f.e.b() != 1) {
                z = false;
            }
            this.b = sVar.a(z);
        } catch (Throwable th) {
        }
    }

    protected void onSessionSucceeded() {
        if (this.a.b == 0) {
            a.c().b(this.c > 0);
            if (this.f.e.a(this.d)) {
                ((DkSignInInfo) this.a.a).mLottery = this.f.b(((DkSignInInfo) this.a.a).mSignStatus, ((DkSignInInfo) this.a.a).mToday, ((DkSignInInfo) this.a.a).mLottery);
                this.f.a(((DkSignInInfo) this.a.a).mSignStatus, ((DkSignInInfo) this.a.a).mToday, ((DkSignInInfo) this.a.a).mLottery);
                if (this.c > 0) {
                    this.f.a(((DkSignInInfo) this.a.a).mSignStatus, ((DkSignInInfo) this.a.a).mToday, this.e, ((DkSignInInfo) this.a.a).mLottery, false, false, true, this.c, (DkStoreAdInfo[]) this.b.a);
                    return;
                }
                this.f.e();
                this.f.a(true);
                return;
            }
            this.f.e();
            be.a(this.f.b, i.general__shared__account_change, 0).show();
            return;
        }
        this.f.e();
        if (TextUtils.isEmpty(this.a.c)) {
            CharSequence string;
            if (this.a.b == 14) {
                string = this.f.b.getResources().getString(i.general__shared__local_time_error);
            } else {
                string = String.format(this.f.b.getString(i.general__shared__unknown_error_code), new Object[]{Integer.valueOf(this.a.b)});
            }
            be.a(this.f.b, string, 0).show();
            return;
        }
        be.a(this.f.b, this.a.c, 0).show();
    }

    protected void onSessionFailed() {
        this.f.e();
        be.a(this.f.b, this.f.b.getString(i.general__shared__network_error), 0).show();
    }
}
