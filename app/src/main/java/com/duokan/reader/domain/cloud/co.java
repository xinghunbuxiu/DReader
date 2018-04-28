package com.duokan.reader.domain.cloud;

import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0647u;
import com.duokan.reader.common.webservices.duokan.C0652z;
import com.duokan.reader.common.webservices.duokan.DkCloudPurchasedFictionInfo;
import com.duokan.reader.common.webservices.duokan.DkStoreFictionDetailInfo;
import com.duokan.reader.domain.account.al;

class co extends WebSession {
    /* renamed from: a */
    final /* synthetic */ al f3822a;
    /* renamed from: b */
    final /* synthetic */ cn f3823b;
    /* renamed from: c */
    private DkCloudPurchasedFiction f3824c = null;

    co(cn cnVar, C0657i c0657i, al alVar) {
        this.f3823b = cnVar;
        this.f3822a = alVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        boolean z;
        dt dtVar = new dt(this.f3822a);
        dtVar.m5468a();
        DkCloudPurchasedFiction dkCloudPurchasedFiction = (DkCloudPurchasedFiction) dtVar.queryItem(this.f3823b.f3821a.f3818a);
        DkCloudPurchasedFictionInfo dkCloudPurchasedFictionInfo = (DkCloudPurchasedFictionInfo) new C0652z((WebSession) this, this.f3822a).m3074e(this.f3823b.f3821a.f3818a).f2058a;
        try {
            C0621a a = new C0647u(this, null).m3035a(this.f3823b.f3821a.f3818a, true, false, -1, -1, -1);
            dkCloudPurchasedFictionInfo.mTitle = ((DkStoreFictionDetailInfo) a.f2058a).mFictionInfo.mTitle;
            dkCloudPurchasedFictionInfo.mAuthors = ((DkStoreFictionDetailInfo) a.f2058a).mFictionInfo.mAuthors;
            dkCloudPurchasedFictionInfo.mChapterCount = ((DkStoreFictionDetailInfo) a.f2058a).mFictionInfo.mChapterCount;
            dkCloudPurchasedFictionInfo.mCoverUri = ((DkStoreFictionDetailInfo) a.f2058a).mFictionInfo.mCoverUri;
            dkCloudPurchasedFictionInfo.mFinish = ((DkStoreFictionDetailInfo) a.f2058a).mFictionInfo.mFinish;
            dkCloudPurchasedFictionInfo.mLatest = ((DkStoreFictionDetailInfo) a.f2058a).mFictionInfo.mLatest;
            dkCloudPurchasedFictionInfo.mLatestId = ((DkStoreFictionDetailInfo) a.f2058a).mFictionInfo.mLatestId;
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
            this.f3824c = (DkCloudPurchasedFiction) dkCloudPurchasedFiction.merge(dkCloudPurchasedFiction2);
            dtVar.updateItem(this.f3824c);
            return;
        }
        this.f3824c = dkCloudPurchasedFiction2;
        dtVar.insertItem(this.f3824c);
    }

    protected void onSessionSucceeded() {
        if (this.f3822a.m3365a(DkUserPurchasedFictionsManager.m5092g())) {
            if (this.f3824c != null) {
                this.f3823b.f3821a.f3820c.f3616h.m5460a(this.f3824c);
                this.f3823b.f3821a.f3820c.m5091f();
            }
            this.f3823b.f3821a.f3819b.mo730a(this.f3824c);
            return;
        }
        this.f3823b.f3821a.f3819b.mo729a(-1, "");
    }

    protected void onSessionFailed() {
        this.f3823b.f3821a.f3819b.mo729a(-1, "");
    }

    protected boolean onSessionException(Exception exception, int i) {
        C0328a.m757c().m748a(LogLevel.ERROR, "pm", String.format("unexpected error while updating purchased chapters(bookUuid: %s).", new Object[]{this.f3823b.f3821a.f3818a}), (Throwable) exception);
        return super.onSessionException(exception, i);
    }
}
