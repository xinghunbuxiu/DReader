package com.duokan.reader.domain.cloud;

import android.text.TextUtils;
import com.duokan.reader.DkPublic;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0652z;
import com.duokan.reader.common.webservices.duokan.DkStoreRedeemBenefitInfo;
import com.duokan.reader.domain.account.al;

class bp extends WebSession {
    /* renamed from: a */
    final /* synthetic */ al f3769a;
    /* renamed from: b */
    final /* synthetic */ bo f3770b;
    /* renamed from: c */
    private DkCloudPurchasedBook f3771c = null;
    /* renamed from: d */
    private DkCloudRedeemBenefit f3772d = null;

    bp(bo boVar, C0657i c0657i, al alVar) {
        this.f3770b = boVar;
        this.f3769a = alVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        cj cjVar = new cj(this.f3769a);
        cjVar.m5406a();
        this.f3771c = (DkCloudPurchasedBook) cjVar.queryItem(this.f3770b.f3767a);
        if (this.f3771c == null) {
            return;
        }
        if (this.f3771c.getRedeemMessage() == null || (DkPublic.isXiaomiId(this.f3771c.getRedeemMessage().getGiver().mUserId) && TextUtils.isEmpty(this.f3771c.getRedeemMessage().getGiver().mNickName))) {
            C0621a g = new C0652z((WebSession) this, this.f3769a).m3077g(this.f3771c.getBookUuid());
            if (g.b == 0) {
                this.f3772d = new DkCloudRedeemBenefit((DkStoreRedeemBenefitInfo) g.f2058a);
                this.f3771c.setRedeemMessage(this.f3772d);
                cjVar.updateItem(this.f3771c);
            }
        }
    }

    protected void onSessionSucceeded() {
        if (this.f3769a.m3365a(DkUserPurchasedBooksManager.m5051h()) && this.f3771c != null) {
            this.f3770b.f3768b.f3608h.m5397a(this.f3771c);
        }
    }

    protected void onSessionFailed() {
    }
}
