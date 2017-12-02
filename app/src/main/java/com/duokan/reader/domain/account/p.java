package com.duokan.reader.domain.account;

import com.duokan.reader.DkApp;

class p implements Runnable {
    final /* synthetic */ Class a;
    final /* synthetic */ u b;
    final /* synthetic */ i c;

    p(i iVar, Class cls, u uVar) {
        this.c = iVar;
        this.a = cls;
        this.b = uVar;
    }

    public void run() {
        a b = this.c.b(this.a);
        if (b.i()) {
            PersonalAccount personalAccount = (PersonalAccount) this.c.b(PersonalAccount.class);
            if (DkApp.get().getAutoLogin()) {
                DkApp.get().setAutoLogin(false);
            }
            personalAccount.o();
            if (MiGuestAccount.class.equals(this.a)) {
                personalAccount.g(new q(this));
                return;
            } else if (MiAccount.class.equals(this.a)) {
                personalAccount.c(new r(this));
                return;
            } else {
                personalAccount.b(new s(this));
                return;
            }
        }
        this.b.onQueryAccountOk(b);
    }
}
