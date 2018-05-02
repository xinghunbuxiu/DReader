package com.duokan.reader.domain.account;

class ck implements C0420b {
    /* renamed from: a */
    final /* synthetic */ C0420b f2467a;
    /* renamed from: b */
    final /* synthetic */ cj f2468b;

    ck(cj cjVar, C0420b c0420b) {
        this.f2468b = cjVar;
        this.f2467a = c0420b;
    }

    public void onLoginOk(C0672a c0672a) {
        this.f2467a.onLoginOk(C0709k.m3476a().m3502b(PersonalAccount.class));
    }

    public void onLoginError(C0672a c0672a, String str) {
        ((MiAccount) C0709k.m3476a().m3502b(MiAccount.class)).mo851u();
        ((MiGuestAccount) C0709k.m3476a().m3502b(MiGuestAccount.class)).mo851u();
        this.f2467a.onLoginError(c0672a, str);
    }
}
