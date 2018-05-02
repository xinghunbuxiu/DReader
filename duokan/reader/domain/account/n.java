package com.duokan.reader.domain.account;

class n implements Runnable {
    final /* synthetic */ u a;
    final /* synthetic */ i b;

    n(i iVar, u uVar) {
        this.b = iVar;
        this.a = uVar;
    }

    public void run() {
        if (!((MiAccount) this.b.b(MiAccount.class)).i()) {
            this.a.onQueryAccountOk(this.b.b(MiAccount.class));
        } else if (((MiGuestAccount) this.b.b(MiGuestAccount.class)).i()) {
            ((PersonalAccount) this.b.b(PersonalAccount.class)).b(new o(this));
        } else {
            this.a.onQueryAccountOk(this.b.b(MiGuestAccount.class));
        }
    }
}
