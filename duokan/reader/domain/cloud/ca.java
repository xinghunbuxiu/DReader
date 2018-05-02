package com.duokan.reader.domain.cloud;

import android.text.TextUtils;

import com.duokan.reader.DkPublic;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.DkStoreRedeemBenefitInfo;
import com.duokan.reader.common.webservices.duokan.aa;
import com.duokan.reader.domain.account.ab;

class ca extends cs {
    final /* synthetic */ ab a;
    final /* synthetic */ bz b;
    private DkCloudPurchasedBook d = null;
    private DkCloudRedeemBenefit e = null;

    ca(bz bzVar, ab abVar) {
        this.b = bzVar;
        this.a = abVar;
        super(bzVar.b);
    }

    protected void onSessionTry() {
        cv cvVar = new cv(this.a);
        cvVar.a();
        this.d = (DkCloudPurchasedBook) cvVar.queryItem(this.b.a);
        if (this.d == null) {
            return;
        }
        if (this.d.getRedeemMessage() == null || (DkPublic.isXiaomiId(this.d.getRedeemMessage().getGiver().mUserId) && TextUtils.isEmpty(this.d.getRedeemMessage().getGiver().mNickName))) {
            b g = new aa((WebSession) this, this.a).g(this.d.getBookUuid());
            if (g.b == 0) {
                this.e = new DkCloudRedeemBenefit((DkStoreRedeemBenefitInfo) g.a);
                this.d.setRedeemMessage(this.e);
                cvVar.updateItem(this.d);
            }
        }
    }

    protected void onSessionSucceeded() {
        if (this.a.a(DkUserPurchasedBooksManager.h()) && this.d != null) {
            this.b.b.h.a(this.d);
        }
    }

    protected void onSessionFailed() {
    }
}
