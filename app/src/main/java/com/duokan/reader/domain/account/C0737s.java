package com.duokan.reader.domain.account;

/* renamed from: com.duokan.reader.domain.account.s */
class C0737s implements C0666x {
    /* renamed from: a */
    final /* synthetic */ C0420b f2500a;
    /* renamed from: b */
    final /* synthetic */ C0735q f2501b;

    C0737s(C0735q c0735q, C0420b c0420b) {
        this.f2501b = c0735q;
        this.f2500a = c0420b;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        if (((MiAccount) c0672a).mo843n()) {
            this.f2501b.f2498c.f2486m.m3374a(this.f2500a);
        } else {
            this.f2501b.f2498c.f2486m.m3375b(this.f2500a);
        }
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f2501b.f2496a.onLoginError(c0672a, str);
    }
}
