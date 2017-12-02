package com.duokan.reader.domain.account;

import com.duokan.reader.DkApp;

class t implements Runnable {
    final /* synthetic */ b a;
    final /* synthetic */ String b;
    final /* synthetic */ i c;

    t(i iVar, b bVar, String str) {
        this.c = iVar;
        this.a = bVar;
        this.b = str;
    }

    public void run() {
        PersonalAccount personalAccount = (PersonalAccount) this.c.b(PersonalAccount.class);
        if (DkApp.get().getTopActivity() == null || DkApp.get().getTopActivity().isFinishing()) {
            this.a.a(personalAccount, "");
        } else if (personalAccount.i()) {
            this.a.a(personalAccount, "");
        } else if (!personalAccount.b().equals(this.b)) {
            this.a.a(personalAccount, "");
        } else if (AccountType.XIAO_MI.equals(personalAccount.e())) {
            MiAccount miAccount = (MiAccount) this.c.b(MiAccount.class);
            if (miAccount != null) {
                miAccount.a(this.a);
            } else {
                this.a.a(personalAccount, "");
            }
        } else if (AccountType.XIAOMI_GUEST.equals(personalAccount.e())) {
            personalAccount.f(this.a);
        } else {
            this.a.a(personalAccount, "");
        }
    }
}
