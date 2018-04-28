package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.webservices.duokan.C0629b;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;

class gm implements C0666x {
    /* renamed from: a */
    final /* synthetic */ gl f3241a;

    gm(gl glVar) {
        this.f3241a = glVar;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        new gn(this, C0629b.f2117a).open();
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f3241a.f3240a.f3238b.release();
    }
}
