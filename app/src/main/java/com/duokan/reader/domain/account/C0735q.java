package com.duokan.reader.domain.account;

import com.duokan.reader.DkApp;

/* renamed from: com.duokan.reader.domain.account.q */
class C0735q implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0420b f2496a;
    /* renamed from: b */
    final /* synthetic */ String f2497b;
    /* renamed from: c */
    final /* synthetic */ C0709k f2498c;

    C0735q(C0709k c0709k, C0420b c0420b, String str) {
        this.f2498c = c0709k;
        this.f2496a = c0420b;
        this.f2497b = str;
    }

    public void run() {
        PersonalAccount personalAccount = (PersonalAccount) this.f2498c.m3502b(PersonalAccount.class);
        if (DkApp.get().getTopActivity() == null || DkApp.get().getTopActivity().isFinishing()) {
            this.f2496a.onLoginError(personalAccount, "");
        } else if (personalAccount.mo839i()) {
            this.f2496a.onLoginError(personalAccount, "");
        } else if (personalAccount.mo832b().equals(this.f2497b)) {
            C0420b c0736r = new C0736r(this);
            if (AccountType.XIAO_MI.equals(personalAccount.mo835e())) {
                this.f2498c.m3497a(MiAccount.class, new C0737s(this, c0736r));
            } else if (AccountType.XIAOMI_GUEST.equals(personalAccount.mo835e())) {
                this.f2498c.f2486m.m3377d(c0736r);
            } else {
                this.f2496a.onLoginError(personalAccount, "");
            }
        } else {
            this.f2496a.onLoginError(personalAccount, "");
        }
    }
}
