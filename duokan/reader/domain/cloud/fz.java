package com.duokan.reader.domain.cloud;

import com.duokan.b.i;
import com.duokan.reader.common.webservices.duokan.DkStoreOrderInfo;
import com.duokan.reader.common.webservices.duokan.DkStoreRedeemFundInfo;
import com.duokan.reader.domain.payment.PaymentResult;
import com.duokan.reader.domain.payment.s;
import com.duokan.reader.domain.store.DkStoreCallback;

class fz implements DkStoreCallback {
    static final /* synthetic */ boolean a = (!fp.class.desiredAssertionStatus());
    final /* synthetic */ fx b;

    fz(fx fxVar) {
        this.b = fxVar;
    }

    public void a(s sVar, PaymentResult paymentResult) {
        if (paymentResult == PaymentResult.VERIFIED_OK) {
            DkStoreRedeemFundInfo dkStoreRedeemFundInfo = new DkStoreRedeemFundInfo();
            dkStoreRedeemFundInfo.mBookUuid = this.b.b.d.b.getBook().getBookUuid();
            dkStoreRedeemFundInfo.mBookCover = this.b.b.d.b.getBook().getCoverUri();
            dkStoreRedeemFundInfo.mBookTitle = this.b.b.d.b.getBook().getTitle();
            dkStoreRedeemFundInfo.mAuthor = this.b.b.d.b.getBook().getAuthorLine();
            dkStoreRedeemFundInfo.mEditor = this.b.b.d.b.getBook().getEditorLine();
            dkStoreRedeemFundInfo.mWords = this.b.c.c;
            dkStoreRedeemFundInfo.mLinkUrl = ((DkStoreOrderInfo) this.b.c.a).mBookUuid;
            this.b.b.d.c.a(new DkCloudRedeemFund(dkStoreRedeemFundInfo));
        } else if (paymentResult == PaymentResult.VERIFIED_NOT_ENOUGH) {
            this.b.b.d.c.a(this.b.b.d.d.c.getString(i.store__shared__pay_not_enough));
        } else if (!a) {
            throw new AssertionError();
        }
    }

    public void a(s sVar, String str) {
        this.b.b.d.c.a(str);
    }

    public void a(s sVar, String str, AbortPayErrorCode abortPayErrorCode) {
        this.b.b.d.c.a(str);
    }
}
