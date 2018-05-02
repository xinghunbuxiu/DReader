package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.a.a;

class bo implements a {
    final /* synthetic */ bn a;

    bo(bn bnVar) {
        this.a = bnVar;
    }

    public void a(Void voidR) {
        new bp(this, DkUserPurchasedBooksManager.h()).open();
    }

    public void a(int i, String str) {
        this.a.b.a(i, str);
    }
}
