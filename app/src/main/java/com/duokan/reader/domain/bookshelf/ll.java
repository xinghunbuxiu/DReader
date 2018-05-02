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

class ll extends ReloginSession {
    /* renamed from: a */
    C0621a<DkSignInInfo> f3555a = new C0621a();
    /* renamed from: b */
    final /* synthetic */ al f3556b;
    /* renamed from: c */
    final /* synthetic */ lk f3557c;

    ll(lk lkVar, String str, C0657i c0657i, al alVar) {
        this.f3557c = lkVar;
        this.f3556b = alVar;
        super(str, c0657i);
    }

    /* renamed from: a */
    public void mo825a() {
        this.f3555a = new C0644r(this, this.f3556b).m3004d();
    }

    /* renamed from: b */
    public void mo827b() {
        if (this.f3555a.b != 0) {
            this.f3557c.f3554a.m4926f();
            if (TextUtils.isEmpty(this.f3555a.c)) {
                CharSequence string;
                if (this.f3555a.b == 14) {
                    string = this.f3557c.f3554a.f3522b.getResources().getString(C0247i.general__shared__local_time_error);
                } else {
                    string = String.format(this.f3557c.f3554a.f3522b.getString(C0247i.general__shared__unknown_error_code), new Object[]{Integer.valueOf(this.f3555a.b)});
                }
                be.m10287a(this.f3557c.f3554a.f3522b, string, 0).show();
            } else {
                be.m10287a(this.f3557c.f3554a.f3522b, this.f3555a.c, 0).show();
            }
            this.f3557c.f3554a.m4922b(true);
        } else if (this.f3557c.f3554a.f3525e.m5209a(this.f3556b)) {
            this.f3557c.f3554a.f3525e.m5218b(((DkSignInInfo) this.f3555a.f2058a).mLottery);
            this.f3557c.f3554a.m4899a(PersonalPrefs.m5175a().m5235k(), PersonalPrefs.m5175a().m5236l(), ((DkSignInInfo) this.f3555a.f2058a).mReward, ((DkSignInInfo) this.f3555a.f2058a).mLottery, true, false);
        } else {
            this.f3557c.f3554a.m4926f();
            be.m10286a(this.f3557c.f3554a.f3522b, C0247i.general__shared__account_change, 0).show();
        }
    }

    /* renamed from: a */
    public void mo826a(String str) {
        this.f3557c.f3554a.m4926f();
        be.m10287a(this.f3557c.f3554a.f3522b, (CharSequence) str, 0).show();
    }

    /* renamed from: c */
    public boolean mo828c() {
        return this.f3555a.b == 1001 || this.f3555a.b == ICallback.LOGIN_OAUTH_AIDL || this.f3555a.b == ICallback.CLEAR_ACCOUNT_AIDL;
    }

    protected void onSessionCancelled() {
        super.onSessionCancelled();
        this.f3557c.f3554a.m4926f();
    }

    protected void onSessionClosed() {
        super.onSessionClosed();
        this.f3557c.f3554a.f3529i = null;
    }
}
