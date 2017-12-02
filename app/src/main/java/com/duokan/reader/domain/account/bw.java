package com.duokan.reader.domain.account;

class bw implements b {
    final /* synthetic */ b a;
    final /* synthetic */ PersonalAccount b;

    bw(PersonalAccount personalAccount, b bVar) {
        this.b = personalAccount;
        this.a = bVar;
    }

    public void a(a aVar) {
        this.a.a(this.b);
        this.b.f = aVar;
        this.b.k = false;
    }

    public void a(a aVar, String str) {
        this.b.g.u();
        this.b.o();
        this.a.a(this.b, str);
        this.b.k = false;
    }
}
