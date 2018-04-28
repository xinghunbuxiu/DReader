package com.duokan.reader.domain.cloud;

import com.duokan.p023b.C0247i;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0652z;
import com.duokan.reader.common.webservices.duokan.DkStoreRedeemFundInfo;
import com.duokan.reader.domain.account.al;

class fh extends WebSession {
    /* renamed from: a */
    final /* synthetic */ al f3998a;
    /* renamed from: b */
    final /* synthetic */ fg f3999b;
    /* renamed from: c */
    private DkCloudRedeemFund[] f4000c = new DkCloudRedeemFund[0];
    /* renamed from: d */
    private boolean f4001d = false;

    fh(fg fgVar, C0657i c0657i, al alVar) {
        this.f3999b = fgVar;
        this.f3998a = alVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        C0621a a = new C0652z((WebSession) this, this.f3998a).m3053a(this.f3999b.f3994a, this.f3999b.f3995b, null);
        if (a.b == 0 && a.f2058a != null) {
            this.f4001d = Boolean.parseBoolean(a.c);
            DkStoreRedeemFundInfo[] dkStoreRedeemFundInfoArr = (DkStoreRedeemFundInfo[]) a.f2058a;
            this.f4000c = new DkCloudRedeemFund[dkStoreRedeemFundInfoArr.length];
            for (int i = 0; i < dkStoreRedeemFundInfoArr.length; i++) {
                this.f4000c[i] = new DkCloudRedeemFund(dkStoreRedeemFundInfoArr[i]);
            }
        }
    }

    protected void onSessionSucceeded() {
        this.f3999b.f3996c.mo1931a(this.f4000c, this.f4001d);
    }

    protected void onSessionFailed() {
        this.f3999b.f3996c.mo1930a(this.f3999b.f3997d.f3957c.getString(C0247i.general__shared__network_error));
    }
}
