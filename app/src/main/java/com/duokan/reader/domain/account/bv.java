package com.duokan.reader.domain.account;

class bv implements C0420b {
    /* renamed from: a */
    final /* synthetic */ C0420b f2451a;
    /* renamed from: b */
    final /* synthetic */ bu f2452b;

    bv(bu buVar, C0420b c0420b) {
        this.f2452b = buVar;
        this.f2451a = c0420b;
    }

    public void onLoginOk(C0672a c0672a) {
        this.f2451a.onLoginOk(C0709k.m3476a().m3502b(PersonalAccount.class));
    }

    public void onLoginError(C0672a c0672a, String str) {
        ((MiAccount) C0709k.m3476a().m3502b(MiAccount.class)).mo851u();
        ((MiGuestAccount) C0709k.m3476a().m3502b(MiGuestAccount.class)).mo851u();
        this.f2451a.onLoginError(c0672a, str);
    }
}
