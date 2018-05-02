package com.duokan.reader.domain.cloud;

import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0647u;
import com.duokan.reader.common.webservices.duokan.DkCloudPurchasedBookInfo;
import com.duokan.reader.common.webservices.duokan.DkStoreBookDetailInfo;
import com.duokan.reader.common.webservices.duokan.DkStoreBookSourceType;
import com.duokan.reader.domain.account.al;

class bx extends WebSession {
    /* renamed from: a */
    final /* synthetic */ al f3790a;
    /* renamed from: b */
    final /* synthetic */ bw f3791b;
    /* renamed from: c */
    private DkCloudPurchasedBook f3792c = null;

    bx(bw bwVar, C0657i c0657i, al alVar) {
        this.f3791b = bwVar;
        this.f3790a = alVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        cj cjVar = new cj(this.f3790a);
        cjVar.m5406a();
        this.f3792c = (DkCloudPurchasedBook) cjVar.queryItem(this.f3791b.f3789a.f3786a);
        if (this.f3792c == null) {
            DkCloudPurchasedBookInfo dkCloudPurchasedBookInfo = new DkCloudPurchasedBookInfo();
            dkCloudPurchasedBookInfo.mBookUuid = this.f3791b.f3789a.f3786a;
            dkCloudPurchasedBookInfo.mOrderUuid = this.f3791b.f3789a.f3786a;
            dkCloudPurchasedBookInfo.setPurchaseTimeInSeconds(System.currentTimeMillis() / 1000);
            dkCloudPurchasedBookInfo.mUpdateTime = dkCloudPurchasedBookInfo.getPurchaseTimeInSeconds();
            dkCloudPurchasedBookInfo.mAd = false;
            dkCloudPurchasedBookInfo.mType = DkStoreBookSourceType.NORMAL;
            try {
                C0621a a = new C0647u(this, null).m3033a(this.f3791b.f3789a.f3786a, false);
                dkCloudPurchasedBookInfo.mTitle = ((DkStoreBookDetailInfo) a.f2058a).mBookInfo.mTitle;
                dkCloudPurchasedBookInfo.mCoverUri = ((DkStoreBookDetailInfo) a.f2058a).mBookInfo.mCoverUri;
                dkCloudPurchasedBookInfo.mAuthors = ((DkStoreBookDetailInfo) a.f2058a).mBookInfo.mAuthors;
                dkCloudPurchasedBookInfo.mEditors = ((DkStoreBookDetailInfo) a.f2058a).mBookInfo.mEditors;
            } catch (Throwable th) {
                dkCloudPurchasedBookInfo.mTitle = "";
                dkCloudPurchasedBookInfo.mCoverUri = "";
                dkCloudPurchasedBookInfo.mAuthors = new String[0];
                dkCloudPurchasedBookInfo.mEditors = new String[0];
            }
            this.f3792c = new DkCloudPurchasedBook(dkCloudPurchasedBookInfo);
            cjVar.insertItem(this.f3792c);
        }
    }

    protected void onSessionSucceeded() {
        if (this.f3790a.m3365a(DkUserPurchasedBooksManager.m5051h())) {
            if (this.f3792c != null) {
                this.f3791b.f3789a.f3788c.f3608h.m5397a(this.f3792c);
                this.f3791b.f3789a.f3788c.m5048f();
            }
            this.f3791b.f3789a.f3787b.mo730a(null);
            return;
        }
        this.f3791b.f3789a.f3787b.mo729a(-1, "");
    }

    protected void onSessionFailed() {
        this.f3791b.f3789a.f3787b.mo729a(-1, "");
    }

    protected boolean onSessionException(Exception exception, int i) {
        WebLog.init().printStackTrace(LogLevel.ERROR, "pm", String.format("unexpected error while marking a book purchased(bookUuid: %s).", new Object[]{this.f3791b.f3789a.f3786a}), (Throwable) exception);
        return super.onSessionException(exception, i);
    }
}
