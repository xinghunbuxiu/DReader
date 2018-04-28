package com.duokan.reader.domain.account;

import com.duokan.reader.domain.statistics.C1163a;

class bs implements C0420b {
    /* renamed from: a */
    final /* synthetic */ br f2449a;

    bs(br brVar) {
        this.f2449a = brVar;
    }

    public void onLoginOk(C0672a c0672a) {
        C1163a.m8627k().m8655c("login", "wechat", "success");
        this.f2449a.f2447b.onLoginOk(C0709k.m3476a().m3502b(MiGuestAccount.class));
    }

    public void onLoginError(C0672a c0672a, String str) {
        C1163a.m8627k().m8655c("login", "wechat", "failed");
        this.f2449a.f2447b.onLoginError(C0709k.m3476a().m3502b(MiGuestAccount.class), str);
    }
}
