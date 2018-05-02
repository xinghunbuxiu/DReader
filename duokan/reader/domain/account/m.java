package com.duokan.reader.domain.account;

class m implements Runnable {
    final /* synthetic */ c a;
    final /* synthetic */ i b;

    m(i iVar, c cVar) {
        this.b = iVar;
        this.a = cVar;
    }

    public void run() {
        a b = this.b.b(PersonalAccount.class);
        if (b.i() || !b.e().equals(AccountType.XIAO_MI)) {
            this.a.a(b);
        } else {
            b.a(this.a);
        }
    }
}
