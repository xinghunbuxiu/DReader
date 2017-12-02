package com.duokan.reader.domain.store;

import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.DkStoreFictionDetailInfo;
import com.duokan.reader.common.webservices.duokan.v;
import com.duokan.reader.domain.account.PersonalAccount;

class c extends com.duokan.reader.common.webservices.duokan.c {
    final /* synthetic */ h a;
    final /* synthetic */ String b;
    final /* synthetic */ boolean c;
    final /* synthetic */ boolean d;
    final /* synthetic */ int e;
    final /* synthetic */ int f;
    final /* synthetic */ int g;
    final /* synthetic */ a h;
    private b i = null;

    c(a aVar, h hVar, String str, boolean z, boolean z2, int i, int i2, int i3) {
        this.h = aVar;
        this.a = hVar;
        this.b = str;
        this.c = z;
        this.d = z2;
        this.e = i;
        this.f = i2;
        this.g = i3;
    }

    protected void onSessionFailed() {
        this.a.onFetchBookDetailError(this.h.a.getString(i.general__shared__network_error));
    }

    protected void onSessionSucceeded() {
        if (this.i.b == 0) {
            this.a.onFetchBookDetailOk(new DkStoreFictionDetail(new DkStoreFiction(((DkStoreFictionDetailInfo) this.i.a).mFictionInfo), (DkStoreFictionDetailInfo) this.i.a));
        } else {
            this.a.onFetchBookDetailError(this.h.a.getString(i.bookcity_store__shared__fail_to_find_book));
        }
    }

    protected void onSessionTry() {
        this.i = new v(this, this.h.b.b(PersonalAccount.class)).a(this.b, this.c, this.d, this.e, this.f, this.g);
    }
}
