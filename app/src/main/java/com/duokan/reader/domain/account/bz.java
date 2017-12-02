package com.duokan.reader.domain.account;

class bz implements b {
    final /* synthetic */ b a;
    final /* synthetic */ PersonalAccount b;

    bz(PersonalAccount personalAccount, b bVar) {
        this.b = personalAccount;
        this.a = bVar;
    }

    public void a(a aVar) {
        if (this.a != null) {
            this.a.a(aVar);
        }
        this.b.k = false;
    }

    public void a(a aVar, String str) {
        this.b.g.u();
        this.b.o();
        if (this.a != null) {
            this.a.a(aVar, str);
        }
        this.b.k = false;
    }
}
