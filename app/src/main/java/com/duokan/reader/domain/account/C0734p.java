package com.duokan.reader.domain.account;

import com.duokan.reader.DkApp;

/* renamed from: com.duokan.reader.domain.account.p */
class C0734p implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Class f2493a;
    /* renamed from: b */
    final /* synthetic */ C0666x f2494b;
    /* renamed from: c */
    final /* synthetic */ C0709k f2495c;

    C0734p(C0709k c0709k, Class cls, C0666x c0666x) {
        this.f2495c = c0709k;
        this.f2493a = cls;
        this.f2494b = c0666x;
    }

    public void run() {
        C0672a b = this.f2495c.m3502b(this.f2493a);
        if (b.mo839i()) {
            PersonalAccount personalAccount = (PersonalAccount) this.f2495c.m3502b(PersonalAccount.class);
            if (DkApp.get().getAutoLogin()) {
                DkApp.get().setAutoLogin(false);
            }
            personalAccount.mo848r();
            this.f2495c.f2481h.m3371a(this.f2493a).mo874a(new cc(this.f2495c, this.f2494b)).mo873a();
            return;
        }
        this.f2494b.onQueryAccountOk(b);
    }
}
