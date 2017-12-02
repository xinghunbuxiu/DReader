package com.duokan.reader.domain.cloud;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.a;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.DkCloudPurchasedFictionInfo;
import com.duokan.reader.common.webservices.duokan.DkStoreFictionDetailInfo;
import com.duokan.reader.common.webservices.duokan.aa;
import com.duokan.reader.common.webservices.duokan.v;
import com.duokan.reader.domain.account.ab;

class da extends ef {
    final /* synthetic */ ab a;
    final /* synthetic */ cz b;
    private DkCloudPurchasedFiction d = null;

    da(cz czVar, ab abVar) {
        this.b = czVar;
        this.a = abVar;
        super(czVar.a.c);
    }

    protected void onSessionTry() {
        boolean z;
        ei eiVar = new ei(this.a);
        eiVar.a();
        DkCloudPurchasedFiction dkCloudPurchasedFiction = (DkCloudPurchasedFiction) eiVar.queryItem(this.b.a.a);
        DkCloudPurchasedFictionInfo dkCloudPurchasedFictionInfo = (DkCloudPurchasedFictionInfo) new aa((WebSession) this, this.a).e(this.b.a.a).a;
        try {
            b a = new v(this, null).a(this.b.a.a, true, false, -1, -1, -1);
            dkCloudPurchasedFictionInfo.mTitle = ((DkStoreFictionDetailInfo) a.a).mFictionInfo.mTitle;
            dkCloudPurchasedFictionInfo.mAuthors = ((DkStoreFictionDetailInfo) a.a).mFictionInfo.mAuthors;
            dkCloudPurchasedFictionInfo.mChapterCount = ((DkStoreFictionDetailInfo) a.a).mFictionInfo.mChapterCount;
            dkCloudPurchasedFictionInfo.mCoverUri = ((DkStoreFictionDetailInfo) a.a).mFictionInfo.mCoverUri;
            dkCloudPurchasedFictionInfo.mFinish = ((DkStoreFictionDetailInfo) a.a).mFictionInfo.mFinish;
            dkCloudPurchasedFictionInfo.mLatest = ((DkStoreFictionDetailInfo) a.a).mFictionInfo.mLatest;
            dkCloudPurchasedFictionInfo.mLatestId = ((DkStoreFictionDetailInfo) a.a).mFictionInfo.mLatestId;
        } catch (Throwable th) {
            dkCloudPurchasedFictionInfo.mTitle = "";
            dkCloudPurchasedFictionInfo.mAuthors = new String[0];
            dkCloudPurchasedFictionInfo.mChapterCount = 1;
            dkCloudPurchasedFictionInfo.mCoverUri = "";
            dkCloudPurchasedFictionInfo.mFinish = false;
            dkCloudPurchasedFictionInfo.mLatest = "";
            dkCloudPurchasedFictionInfo.mLatestId = "0";
        }
        if (dkCloudPurchasedFiction == null || !dkCloudPurchasedFiction.isHidden()) {
            z = false;
        } else {
            z = true;
        }
        DkCloudItem dkCloudPurchasedFiction2 = new DkCloudPurchasedFiction(dkCloudPurchasedFictionInfo, z);
        if (dkCloudPurchasedFiction != null) {
            this.d = (DkCloudPurchasedFiction) dkCloudPurchasedFiction.merge(dkCloudPurchasedFiction2);
            eiVar.updateItem(this.d);
            return;
        }
        this.d = dkCloudPurchasedFiction2;
        eiVar.insertItem(this.d);
    }

    protected void onSessionSucceeded() {
        if (this.a.a(DkUserPurchasedFictionsManager.g())) {
            if (this.d != null) {
                this.b.a.c.h.a(this.d);
                this.b.a.c.f();
            }
            this.b.a.b.a(this.d);
            return;
        }
        this.b.a.b.a(-1, "");
    }

    protected void onSessionFailed() {
        this.b.a.b.a(-1, "");
    }

    protected boolean onSessionException(Exception exception, int i) {
        a.c().a(LogLevel.ERROR, "pm", String.format("unexpected error while updating purchased chapters(bookUuid: %s).", new Object[]{this.b.a.a}), (Throwable) exception);
        return super.onSessionException(exception, i);
    }
}
