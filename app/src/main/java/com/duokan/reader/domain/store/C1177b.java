package com.duokan.reader.domain.store;

import com.duokan.p023b.C0247i;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0647u;
import com.duokan.reader.common.webservices.duokan.DkStoreBookDetailInfo;
import com.duokan.reader.domain.account.PersonalAccount;

/* renamed from: com.duokan.reader.domain.store.b */
class C1177b extends WebSession {
    /* renamed from: a */
    final /* synthetic */ C0466h f5635a;
    /* renamed from: b */
    final /* synthetic */ String f5636b;
    /* renamed from: c */
    final /* synthetic */ boolean f5637c;
    /* renamed from: d */
    final /* synthetic */ String f5638d;
    /* renamed from: e */
    final /* synthetic */ C1176a f5639e;
    /* renamed from: f */
    private C0621a<DkStoreBookDetailInfo> f5640f = null;

    C1177b(C1176a c1176a, C0657i c0657i, C0466h c0466h, String str, boolean z, String str2) {
        this.f5639e = c1176a;
        this.f5635a = c0466h;
        this.f5636b = str;
        this.f5637c = z;
        this.f5638d = str2;
        super(c0657i);
    }

    protected void onSessionFailed() {
        this.f5635a.onFetchBookDetailError(this.f5639e.f5630a.getString(C0247i.general__shared__network_error));
    }

    protected void onSessionSucceeded() {
        if (this.f5640f.b == 0) {
            this.f5635a.onFetchBookDetailOk(new DkStoreBookDetail(new DkStoreBook(((DkStoreBookDetailInfo) this.f5640f.f2058a).mBookInfo), (DkStoreBookDetailInfo) this.f5640f.f2058a));
        } else {
            this.f5635a.onFetchBookDetailError(this.f5639e.f5630a.getString(C0247i.bookcity_store__shared__fail_to_find_book));
        }
    }

    protected void onSessionTry() {
        this.f5640f = new C0647u(this, this.f5639e.f5631b.m3502b(PersonalAccount.class)).m3034a(this.f5636b, this.f5637c, this.f5638d);
    }
}
