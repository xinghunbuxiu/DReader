package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.i;

class dy implements as {
    final /* synthetic */ String a;
    final /* synthetic */ dx b;

    dy(dx dxVar, String str) {
        this.b = dxVar;
        this.a = str;
    }

    public void a() {
        PersonalAccount personalAccount = (PersonalAccount) i.f().b(PersonalAccount.class);
        if (personalAccount != null && !personalAccount.i()) {
            personalAccount.g(new dz(this));
        }
    }
}
