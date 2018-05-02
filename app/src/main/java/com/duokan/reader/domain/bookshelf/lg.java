package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;
import com.duokan.p023b.C0247i;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.duokan.C0644r;
import com.duokan.reader.common.webservices.duokan.DkSignInInfo;
import com.duokan.reader.domain.account.ReloginSession;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.ui.general.be;
import com.wali.live.sdk.manager.IMiLiveSdk.ICallback;

class lg extends ReloginSession {
    /* renamed from: a */
    C0621a<DkSignInInfo> f3541a = new C0621a();
    /* renamed from: b */
    C0621a<DkSignInInfo> f3542b = new C0621a();
    /* renamed from: c */
    final /* synthetic */ al f3543c;
    /* renamed from: d */
    final /* synthetic */ lf f3544d;

    lg(lf lfVar, String str, C0657i c0657i, al alVar) {
        this.f3544d = lfVar;
        this.f3543c = alVar;
        super(str, c0657i);
    }

    /* renamed from: a */
    public void mo825a() {
        C0644r c0644r = new C0644r(this, this.f3543c);
        this.f3541a = c0644r.m3002b();
        if (this.f3541a.b == 0 && this.f3544d.f3540a.f3525e.m5209a(this.f3543c)) {
            ((DkSignInInfo) this.f3541a.f2058a).mLottery = this.f3544d.f3540a.m4905b(((DkSignInInfo) this.f3541a.f2058a).mSignStatus, ((DkSignInInfo) this.f3541a.f2058a).mToday, ((DkSignInInfo) this.f3541a.f2058a).mLottery);
            if (((DkSignInInfo) this.f3541a.f2058a).mLottery) {
                this.f3542b = c0644r.m3004d();
            }
        }
    }

    /* renamed from: b */
    public void mo827b() {
        if (!this.f3544d.f3540a.f3525e.m5209a(this.f3543c)) {
            this.f3544d.f3540a.m4926f();
            be.m10286a(this.f3544d.f3540a.f3522b, C0247i.general__shared__account_change, 0).show();
        } else if (this.f3541a.b != 0) {
            this.f3544d.f3540a.m4926f();
            if (TextUtils.isEmpty(this.f3541a.c)) {
                CharSequence string;
                if (this.f3541a.b == 14) {
                    string = this.f3544d.f3540a.f3522b.getResources().getString(C0247i.general__shared__local_time_error);
                } else {
                    string = String.format(this.f3544d.f3540a.f3522b.getString(C0247i.general__shared__unknown_error_code), new Object[]{Integer.valueOf(this.f3541a.b)});
                }
                be.m10287a(this.f3544d.f3540a.f3522b, string, 0).show();
            } else {
                be.m10287a(this.f3544d.f3540a.f3522b, this.f3541a.c, 0).show();
            }
            this.f3544d.f3540a.m4922b(true);
        } else if (((DkSignInInfo) this.f3541a.f2058a).mLottery) {
            this.f3544d.f3540a.m4900a(((DkSignInInfo) this.f3541a.f2058a).mSignStatus, ((DkSignInInfo) this.f3541a.f2058a).mToday, true);
            if (this.f3542b.b != 0) {
                this.f3544d.f3540a.m4899a(((DkSignInInfo) this.f3541a.f2058a).mSignStatus, ((DkSignInInfo) this.f3541a.f2058a).mToday, ((DkSignInInfo) this.f3541a.f2058a).mReward, true, false, false);
                return;
            }
            PersonalPrefs.m5175a().m5218b(((DkSignInInfo) this.f3542b.f2058a).mLottery);
            ((DkSignInInfo) this.f3541a.f2058a).mReward.addAll(((DkSignInInfo) this.f3542b.f2058a).mReward);
            this.f3544d.f3540a.m4899a(((DkSignInInfo) this.f3541a.f2058a).mSignStatus, ((DkSignInInfo) this.f3541a.f2058a).mToday, ((DkSignInInfo) this.f3541a.f2058a).mReward, ((DkSignInInfo) this.f3542b.f2058a).mLottery, true, false);
        } else {
            this.f3544d.f3540a.m4900a(((DkSignInInfo) this.f3541a.f2058a).mSignStatus, ((DkSignInInfo) this.f3541a.f2058a).mToday, false);
            this.f3544d.f3540a.m4899a(((DkSignInInfo) this.f3541a.f2058a).mSignStatus, ((DkSignInInfo) this.f3541a.f2058a).mToday, ((DkSignInInfo) this.f3541a.f2058a).mReward, false, false, false);
        }
    }

    /* renamed from: a */
    public void mo826a(String str) {
        this.f3544d.f3540a.m4926f();
        be.m10287a(this.f3544d.f3540a.f3522b, (CharSequence) str, 0).show();
    }

    /* renamed from: c */
    public boolean mo828c() {
        return this.f3541a.b == 1001 || this.f3541a.b == ICallback.LOGIN_OAUTH_AIDL || this.f3541a.b == ICallback.CLEAR_ACCOUNT_AIDL || this.f3542b.b == 1001 || this.f3542b.b == ICallback.LOGIN_OAUTH_AIDL || this.f3542b.b == ICallback.CLEAR_ACCOUNT_AIDL;
    }

    protected void onSessionCancelled() {
        super.onSessionCancelled();
        this.f3544d.f3540a.m4926f();
    }

    protected void onSessionClosed() {
        super.onSessionClosed();
        this.f3544d.f3540a.f3530j = null;
    }
}
