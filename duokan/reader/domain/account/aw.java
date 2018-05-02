package com.duokan.reader.domain.account;

class aw implements Runnable {
    final /* synthetic */ b a;
    final /* synthetic */ MiAccount b;

    aw(MiAccount miAccount, b bVar) {
        this.b = miAccount;
        this.a = bVar;
    }

    public void run() {
        MiAccount.e.a(this.b, this.a);
    }
}
