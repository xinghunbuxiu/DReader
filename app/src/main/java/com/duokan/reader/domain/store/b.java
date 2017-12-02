package com.duokan.reader.domain.store;

import com.duokan.b.i;
import com.duokan.reader.common.webservices.duokan.DkStoreBookDetailInfo;
import com.duokan.reader.common.webservices.duokan.c;
import com.duokan.reader.common.webservices.duokan.v;
import com.duokan.reader.domain.account.PersonalAccount;

class b extends c {
    final /* synthetic */ h a;
    final /* synthetic */ String b;
    final /* synthetic */ boolean c;
    final /* synthetic */ String d;
    final /* synthetic */ a e;
    private com.duokan.reader.common.webservices.b f = null;

    b(a aVar, h hVar, String str, boolean z, String str2) {
        this.e = aVar;
        this.a = hVar;
        this.b = str;
        this.c = z;
        this.d = str2;
    }

    protected void onSessionFailed() {
        this.a.onFetchBookDetailError(this.e.a.getString(i.general__shared__network_error));
    }

    protected void onSessionSucceeded() {
        if (this.f.b == 0) {
            this.a.onFetchBookDetailOk(new DkStoreBookDetail(new DkStoreBook(((DkStoreBookDetailInfo) this.f.a).mBookInfo), (DkStoreBookDetailInfo) this.f.a));
        } else {
            this.a.onFetchBookDetailError(this.e.a.getString(i.bookcity_store__shared__fail_to_find_book));
        }
    }

    protected void onSessionTry() {
        this.f = new v(this, this.e.b.b(PersonalAccount.class)).a(this.b, this.c, this.d);
    }
}
