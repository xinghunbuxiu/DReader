package com.duokan.reader.ui.surfing;

import com.duokan.c.j;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.b;
import com.duokan.reader.ui.general.be;

class k implements b {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    public void a(a aVar) {
        DkApp.get().setAutoLogin(false);
        be.a(this.a.a.getContext(), this.a.a.getString(j.bookshelf__shared__auto_login_succeed), 0).show();
        this.a.a();
    }

    public void a(a aVar, String str) {
        DkApp.get().setAutoLogin(false);
        if (this.a.a.q != null && this.a.a.q.isActive()) {
            this.a.a.q.h();
        }
        this.a.a();
    }
}
