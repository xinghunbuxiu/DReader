package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.i;

class dv implements as {
    final /* synthetic */ String a;
    final /* synthetic */ du b;

    dv(du duVar, String str) {
        this.b = duVar;
        this.a = str;
    }

    public void a() {
        ((PersonalAccount) i.f().b(PersonalAccount.class)).e(new dw(this));
    }
}
