package com.duokan.reader.domain.cloud;

import com.duokan.b.i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.DkStoreRedeemFundInfo;
import com.duokan.reader.common.webservices.duokan.aa;
import com.duokan.reader.common.webservices.duokan.b;
import com.duokan.reader.domain.account.ab;

class gb extends b {
    final /* synthetic */ ab a;
    final /* synthetic */ ga b;
    private DkCloudRedeemFund[] c = new DkCloudRedeemFund[0];
    private boolean d = false;

    gb(ga gaVar, ab abVar) {
        this.b = gaVar;
        this.a = abVar;
    }

    protected void onSessionTry() {
        com.duokan.reader.common.webservices.b a = new aa((WebSession) this, this.a).a(this.b.a, this.b.b, null);
        if (a.b == 0 && a.a != null) {
            this.d = Boolean.parseBoolean(a.c);
            DkStoreRedeemFundInfo[] dkStoreRedeemFundInfoArr = (DkStoreRedeemFundInfo[]) a.a;
            this.c = new DkCloudRedeemFund[dkStoreRedeemFundInfoArr.length];
            for (int i = 0; i < dkStoreRedeemFundInfoArr.length; i++) {
                this.c[i] = new DkCloudRedeemFund(dkStoreRedeemFundInfoArr[i]);
            }
        }
    }

    protected void onSessionSucceeded() {
        this.b.c.a(this.c, this.d);
    }

    protected void onSessionFailed() {
        this.b.c.a(this.b.d.c.getString(i.general__shared__network_error));
    }
}
