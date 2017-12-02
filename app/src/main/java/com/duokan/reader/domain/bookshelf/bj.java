package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.async.a.a;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;

class bj implements a {
    final /* synthetic */ iq a;
    final /* synthetic */ boolean b;
    final /* synthetic */ boolean c;
    final /* synthetic */ int d;
    final /* synthetic */ ab e;
    final /* synthetic */ aq f;

    bj(aq aqVar, iq iqVar, boolean z, boolean z2, int i, ab abVar) {
        this.f = aqVar;
        this.a = iqVar;
        this.b = z;
        this.c = z2;
        this.d = i;
        this.e = abVar;
    }

    public void a(Void voidR) {
        if (!this.a.isCancelled()) {
            DkUserPurchasedBooksManager.a().b(false, true, new bk(this));
        }
    }

    public void a(int i, String str) {
        if (!this.a.isCancelled()) {
            this.f.i(str);
        }
    }
}
