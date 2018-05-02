package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.domain.account.MiAccount;
import com.duokan.reader.domain.account.i;

class df implements as {
    final /* synthetic */ String a;
    final /* synthetic */ de b;

    df(de deVar, String str) {
        this.b = deVar;
        this.a = str;
    }

    public void a() {
        if (i.f().a(MiAccount.class)) {
            i.f().a(i.f().b(MiAccount.class).b(), new dg(this));
            return;
        }
        i.f().a(new dh(this));
    }
}
