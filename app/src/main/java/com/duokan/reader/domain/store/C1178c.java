package com.duokan.reader.domain.store;

import com.duokan.p023b.C0247i;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0647u;
import com.duokan.reader.common.webservices.duokan.DkStoreFictionDetailInfo;
import com.duokan.reader.domain.account.PersonalAccount;

/* renamed from: com.duokan.reader.domain.store.c */
class C1178c extends WebSession {
    /* renamed from: a */
    final /* synthetic */ C0466h f5641a;
    /* renamed from: b */
    final /* synthetic */ String f5642b;
    /* renamed from: c */
    final /* synthetic */ boolean f5643c;
    /* renamed from: d */
    final /* synthetic */ boolean f5644d;
    /* renamed from: e */
    final /* synthetic */ int f5645e;
    /* renamed from: f */
    final /* synthetic */ int f5646f;
    /* renamed from: g */
    final /* synthetic */ int f5647g;
    /* renamed from: h */
    final /* synthetic */ C1176a f5648h;
    /* renamed from: i */
    private C0621a<DkStoreFictionDetailInfo> f5649i = null;

    C1178c(C1176a c1176a, C0657i c0657i, C0466h c0466h, String str, boolean z, boolean z2, int i, int i2, int i3) {
        this.f5648h = c1176a;
        this.f5641a = c0466h;
        this.f5642b = str;
        this.f5643c = z;
        this.f5644d = z2;
        this.f5645e = i;
        this.f5646f = i2;
        this.f5647g = i3;
        super(c0657i);
    }

    protected void onSessionFailed() {
        this.f5641a.onFetchBookDetailError(this.f5648h.f5630a.getString(C0247i.general__shared__network_error));
    }

    protected void onSessionSucceeded() {
        if (this.f5649i.b == 0) {
            this.f5641a.onFetchBookDetailOk(new DkStoreFictionDetail(new DkStoreFiction(((DkStoreFictionDetailInfo) this.f5649i.f2058a).mFictionInfo), (DkStoreFictionDetailInfo) this.f5649i.f2058a));
        } else {
            this.f5641a.onFetchBookDetailError(this.f5648h.f5630a.getString(C0247i.bookcity_store__shared__fail_to_find_book));
        }
    }

    protected void onSessionTry() {
        this.f5649i = new C0647u(this, this.f5648h.f5631b.m3502b(PersonalAccount.class)).m3035a(this.f5642b, this.f5643c, this.f5644d, this.f5645e, this.f5646f, this.f5647g);
    }
}
