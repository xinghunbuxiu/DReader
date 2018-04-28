package com.duokan.reader.domain.cloud;

import com.duokan.p023b.C0247i;
import com.duokan.reader.common.webservices.duokan.DkStoreOrderInfo;
import com.duokan.reader.common.webservices.duokan.DkStoreRedeemFundInfo;
import com.duokan.reader.domain.payment.C1089s;
import com.duokan.reader.domain.payment.PaymentResult;
import com.duokan.reader.domain.store.DkStoreCallback;
import com.duokan.reader.domain.store.DkStoreCallback.AbortPayErrorCode;

class ff implements DkStoreCallback {
    /* renamed from: a */
    static final /* synthetic */ boolean f3992a = (!ex.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ fe f3993b;

    ff(fe feVar) {
        this.f3993b = feVar;
    }

    /* renamed from: a */
    public void mo1163a(C1089s c1089s, PaymentResult paymentResult) {
        if (paymentResult == PaymentResult.VERIFIED_OK) {
            DkStoreRedeemFundInfo dkStoreRedeemFundInfo = new DkStoreRedeemFundInfo();
            dkStoreRedeemFundInfo.mBookUuid = this.f3993b.f3990b.f3988d.f3982b.getBook().getBookUuid();
            dkStoreRedeemFundInfo.mBookCover = this.f3993b.f3990b.f3988d.f3982b.getBook().getCoverUri();
            dkStoreRedeemFundInfo.mBookTitle = this.f3993b.f3990b.f3988d.f3982b.getBook().getTitle();
            dkStoreRedeemFundInfo.mAuthor = this.f3993b.f3990b.f3988d.f3982b.getBook().getAuthorLine();
            dkStoreRedeemFundInfo.mEditor = this.f3993b.f3990b.f3988d.f3982b.getBook().getEditorLine();
            dkStoreRedeemFundInfo.mWords = this.f3993b.f3991c.c;
            dkStoreRedeemFundInfo.mLinkUrl = ((DkStoreOrderInfo) this.f3993b.f3991c.f2058a).mBookUuid;
            this.f3993b.f3990b.f3988d.f3983c.mo1160a(new DkCloudRedeemFund(dkStoreRedeemFundInfo));
        } else if (paymentResult == PaymentResult.VERIFIED_NOT_ENOUGH) {
            this.f3993b.f3990b.f3988d.f3983c.mo1161a(this.f3993b.f3990b.f3988d.f3984d.f3957c.getString(C0247i.store__shared__pay_not_enough));
        } else if (!f3992a) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public void mo1164a(C1089s c1089s, String str) {
        this.f3993b.f3990b.f3988d.f3983c.mo1161a(str);
    }

    /* renamed from: a */
    public void mo1165a(C1089s c1089s, String str, AbortPayErrorCode abortPayErrorCode) {
        this.f3993b.f3990b.f3988d.f3983c.mo1161a(str);
    }
}
