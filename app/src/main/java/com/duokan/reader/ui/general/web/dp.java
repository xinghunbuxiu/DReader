package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.domain.account.MiAccount;
import com.duokan.reader.domain.account.i;

class dp implements as {
    final /* synthetic */ String a;
    final /* synthetic */ do b;

    dp(do doVar, String str) {
        this.b = doVar;
        this.a = str;
    }

    public void a() {
        i.f().a(MiAccount.class, new dq(this));
    }
}
