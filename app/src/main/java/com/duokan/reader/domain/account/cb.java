package com.duokan.reader.domain.account;

import com.duokan.reader.domain.statistics.a;

class cb implements b {
    final /* synthetic */ b a;
    final /* synthetic */ PersonalAccount b;

    cb(PersonalAccount personalAccount, b bVar) {
        this.b = personalAccount;
        this.a = bVar;
    }

    public void a(a aVar) {
        a.k().b("login", "wechat", "success");
        this.a.a(i.f().b(MiGuestAccount.class));
        this.b.k = false;
    }

    public void a(a aVar, String str) {
        a.k().b("login", "wechat", "failed");
        this.b.o();
        this.a.a(i.f().b(MiGuestAccount.class), str);
        this.b.k = false;
    }
}
