package com.duokan.reader.domain.account;

/* renamed from: com.duokan.reader.domain.account.o */
class C0713o implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0666x f2491a;
    /* renamed from: b */
    final /* synthetic */ C0709k f2492b;

    C0713o(C0709k c0709k, C0666x c0666x) {
        this.f2492b = c0709k;
        this.f2491a = c0666x;
    }

    public void run() {
        if (!((MiAccount) this.f2492b.m3502b(MiAccount.class)).mo839i()) {
            this.f2491a.onQueryAccountOk(this.f2492b.m3502b(MiAccount.class));
        } else if (((MiGuestAccount) this.f2492b.m3502b(MiGuestAccount.class)).mo839i()) {
            this.f2492b.f2481h.m3371a(UserAccount.class).mo874a(new cc(this.f2492b, this.f2491a)).mo873a();
        } else {
            this.f2491a.onQueryAccountOk(this.f2492b.m3502b(MiGuestAccount.class));
        }
    }
}
