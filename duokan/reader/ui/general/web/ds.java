package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.i;

class ds implements as {
    final /* synthetic */ String a;
    final /* synthetic */ dr b;

    ds(dr drVar, String str) {
        this.b = drVar;
        this.a = str;
    }

    public void a() {
        ((PersonalAccount) i.f().b(PersonalAccount.class)).d(new dt(this));
    }
}
