package com.duokan.reader.domain.cloud;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.DkCloudPurchasedBookInfo;
import com.duokan.reader.common.webservices.duokan.DkStoreBookDetailInfo;
import com.duokan.reader.common.webservices.duokan.DkStoreBookSourceType;
import com.duokan.reader.common.webservices.duokan.v;
import com.duokan.reader.domain.account.ab;

class ci extends cs {
    final /* synthetic */ ab a;
    final /* synthetic */ ch b;
    private DkCloudPurchasedBook d = null;

    ci(ch chVar, ab abVar) {
        this.b = chVar;
        this.a = abVar;
        super(chVar.a.c);
    }

    protected void onSessionTry() {
        cv cvVar = new cv(this.a);
        cvVar.a();
        this.d = (DkCloudPurchasedBook) cvVar.queryItem(this.b.a.a);
        if (this.d == null) {
            DkCloudPurchasedBookInfo dkCloudPurchasedBookInfo = new DkCloudPurchasedBookInfo();
            dkCloudPurchasedBookInfo.mBookUuid = this.b.a.a;
            dkCloudPurchasedBookInfo.mOrderUuid = this.b.a.a;
            dkCloudPurchasedBookInfo.setPurchaseTimeInSeconds(System.currentTimeMillis() / 1000);
            dkCloudPurchasedBookInfo.mUpdateTime = dkCloudPurchasedBookInfo.getPurchaseTimeInSeconds();
            dkCloudPurchasedBookInfo.mAd = false;
            dkCloudPurchasedBookInfo.mType = DkStoreBookSourceType.NORMAL;
            try {
                b a = new v(this, null).a(this.b.a.a, false);
                dkCloudPurchasedBookInfo.mTitle = ((DkStoreBookDetailInfo) a.a).mBookInfo.mTitle;
                dkCloudPurchasedBookInfo.mCoverUri = ((DkStoreBookDetailInfo) a.a).mBookInfo.mCoverUri;
                dkCloudPurchasedBookInfo.mAuthors = ((DkStoreBookDetailInfo) a.a).mBookInfo.mAuthors;
                dkCloudPurchasedBookInfo.mEditors = ((DkStoreBookDetailInfo) a.a).mBookInfo.mEditors;
            } catch (Throwable th) {
                dkCloudPurchasedBookInfo.mTitle = "";
                dkCloudPurchasedBookInfo.mCoverUri = "";
                dkCloudPurchasedBookInfo.mAuthors = new String[0];
                dkCloudPurchasedBookInfo.mEditors = new String[0];
            }
            this.d = new DkCloudPurchasedBook(dkCloudPurchasedBookInfo);
            cvVar.insertItem(this.d);
        }
    }

    protected void onSessionSucceeded() {
        if (this.a.a(DkUserPurchasedBooksManager.h())) {
            if (this.d != null) {
                this.b.a.c.h.a(this.d);
                this.b.a.c.f();
            }
            this.b.a.b.a(null);
            return;
        }
        this.b.a.b.a(-1, "");
    }

    protected void onSessionFailed() {
        this.b.a.b.a(-1, "");
    }

    protected boolean onSessionException(Exception exception, int i) {
        a.c().a(LogLevel.ERROR, "pm", String.format("unexpected error while marking setDrawable book purchased(bookUuid: %s).", new Object[]{this.b.a.a}), (Throwable) exception);
        return super.onSessionException(exception, i);
    }
}
