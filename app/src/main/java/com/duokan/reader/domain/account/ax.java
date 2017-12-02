package com.duokan.reader.domain.account;

class ax implements Runnable {
    final /* synthetic */ b a;
    final /* synthetic */ MiAccount b;

    ax(MiAccount miAccount, b bVar) {
        this.b = miAccount;
        this.a = bVar;
    }

    public void run() {
        MiAccount.e.b(this.b, this.a);
    }
}
